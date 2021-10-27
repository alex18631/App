package ru.filippov.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.filippov.app.logic.userEntity;
import ru.filippov.app.logic.userRepository;

@RestController
public class userController {

    userRepository a;

    public userController(userRepository a) {
        this.a = a;
    }
    @PostMapping("/")
    public ResponseEntity show (){
        a.save(new userEntity("1","Alex"));
        return ResponseEntity.ok("Ой ой ой");
    }
    @GetMapping("/get")
     public userEntity getByID(String id){
        return new userEntity("1","Alex");
     }

}
