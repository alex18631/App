package ru.filippov.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.filippov.app.logic.userEntity;
import ru.filippov.app.logic.userRepository;
import ru.filippov.app.logic.userResponsePost;

@RestController()
public class userController {


   private final userRepository userRepository;

    public userController(userRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/mortgage/application")
    public userEntity createUser (@RequestBody userResponsePost user){

        return userRepository.save(user.getCustomer(user));
    }
    @GetMapping("/mortgage/application/{id}")
     public ResponseEntity<userEntity> getByID(@PathVariable("id") String id){
        var customerOpt =userRepository.findById(id);
        return ResponseEntity.of(customerOpt);
     }

}
