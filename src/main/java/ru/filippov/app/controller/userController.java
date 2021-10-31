package ru.filippov.app.controller;

import org.openapitools.client.api.MortgageCalculatorApi;
import org.openapitools.client.model.MortgageCalculateParams;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.filippov.app.logic.CreateMortgageApplication;
import ru.filippov.app.logic.MortgageApplication;
import ru.filippov.app.logic.MortgageApplicationStatus;
import ru.filippov.app.logic.userRepository;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

@RestController()
public class userController {


    private final userRepository userRepository;

    public userController(userRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/mortgage/application")
    public ResponseEntity createUser(@RequestBody CreateMortgageApplication user) {
        MortgageApplication duplicate = userRepository.findByFirstNameAndSecondNameAndLastNameAndPassport(user.getFirstName()
                , user.getSecondName(), user.getLastName(), user.getPassport());

        if (user.getDurationInMonth() == 0 && user.getCreditAmount() == 0) {
            return ResponseEntity.badRequest().
                    body(Collections.singletonMap("error", "durationInMonths: не должно равняться null;" +
                            " creditAmount: не должно равняться null"));
        }

        if (!user.poleNoEmpty()) {
            return ResponseEntity.badRequest().
                    body(Collections.singletonMap("error", "one of the fields is null"));

        }
        if (duplicate != null) {
            return ResponseEntity.badRequest().
                    body(Collections.singletonMap("error", "Application exist"));
        }

        MortgageApplication save = user.getCustomer(user);
        MortgageCalculateParams creditParams = new MortgageCalculateParams();
        MortgageCalculatorApi calculate = new MortgageCalculatorApi();
        creditParams.setCreditAmount(BigDecimal.valueOf(user.getCreditAmount()));
        creditParams.setDurationInMonths(user.getDurationInMonth());
        BigDecimal result = calculate.calculate(creditParams).getMonthlyPayment();
        if (user.getSalary() / result.doubleValue() >= 2) {
            save.setStatus(MortgageApplicationStatus.APPROVED);
            save.setMonthlyPayment(result);
        } else {
            save.setStatus(MortgageApplicationStatus.DENIED);
        }
        userRepository.save(save);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                build(Collections.singletonMap("id", save.getId()))).body(save);


    }

    @GetMapping("/mortgage/application/{id}")
    public ResponseEntity getByID(@PathVariable("id") String id) {
        Optional<MortgageApplication> userOpt;
        userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            return ResponseEntity.of(userOpt);
        }
        return ResponseEntity.badRequest().
                body(Collections.singletonMap("error", "Application not exist"));
    }
}



