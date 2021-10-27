package ru.filippov.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.filippov.app.logic.userEntity;
import ru.filippov.app.logic.userRepository;

import java.util.List;

@RestController
public class userController {

    userRepository userRepository;

    public userController(userRepository a) {
        this.userRepository = a;
    }

    @PostMapping("/a")
    public ResponseEntity show (){
        userRepository.save(new userEntity("1","Alex"));
        return ResponseEntity.ok("Ой ой ой");
    }
    @GetMapping("/get")
     public List<userEntity> getByID(String id){
        return userRepository.findAll();
     }

}
