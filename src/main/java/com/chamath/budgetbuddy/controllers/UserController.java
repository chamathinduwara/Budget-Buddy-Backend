package com.chamath.budgetbuddy.controllers;

import com.chamath.budgetbuddy.dto.LoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/get")
    public ResponseEntity<String > getUser() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping("/post")
    public ResponseEntity<String> postUser(@RequestBody LoginDto loginDto){
        System.out.println("Helloworld");
        String s = loginDto.getPassword();
        return ResponseEntity.ok(s);
    }
}
