package com.jpa.example.jpa_example.controller;

import com.jpa.example.jpa_example.model.User;
import com.jpa.example.jpa_example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/test/crud")
public class UserController {
    private final UserService userService;

    @GetMapping("/save/{id}/{password}/{userName}")
    public ResponseEntity save(@PathVariable String id, @PathVariable String password, @PathVariable String userName){
        User user = new User(id, password, userName);

        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){
        userService.delete(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/readById")
    public ResponseEntity readById(@RequestParam String id){
        return ResponseEntity.ok(userService.readById(id));
    }

    @GetMapping("/readByUserName")
    public ResponseEntity readByUserName(@RequestParam String userName){
        return ResponseEntity.ok(userService.readByUserName(userName));
    }

    @GetMapping("/update/{id}/{password}/{userName}")
    public ResponseEntity update(@PathVariable String id, @PathVariable String password, @PathVariable String userName){
        User user = new User(id, password, userName);

        return ResponseEntity.ok(userService.update(user));
    }
}
