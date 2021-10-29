package ru.filippov.app.controller;

import org.hibernate.mapping.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.filippov.app.logic.MortgageApplication;
import ru.filippov.app.logic.userRepository;
import ru.filippov.app.logic.CreateMortgageApplication;

import java.util.Collections;

@RestController()
public class userController {


    private final userRepository userRepository;

    public userController(userRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/mortgage/application")//Нужно дописать обработку запроса от внешнего сервиса(если зарплата больше кредите или меньше)
    public ResponseEntity createUser(@RequestBody CreateMortgageApplication user) {
        var duplicate = userRepository.findByFirstNameAndSecondNameAndLastNameAndPassport(user.getFirstName()
                , user.getSecondName(), user.getLastName(), user.getPassport());
        if (!user.poleNoEmpty()) {
            return ResponseEntity.badRequest().
                    body(Collections.singletonMap("error", "one of the fields is null"));
        }
        if (duplicate != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).
                    body(Collections.singletonMap("error", "This application already exists"));
        }
        userRepository.save(user.getCustomer(user));
        var save =userRepository.save(user.getCustomer(user));
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                build(Collections.singletonMap("id", save.getId()))).body(user);

    }

    @GetMapping("/mortgage/application/{id}")
    public ResponseEntity<MortgageApplication> getByID(@PathVariable("id") String id) {
        var userOpt = userRepository.findById(id);
        return ResponseEntity.of(userOpt);
    }
}
