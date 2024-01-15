package com.example.infrastructure;

import com.example.application.LoginService;
import com.example.application.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final LoginService loginService;
    private final RegisterService registerService;

    @Autowired
    public UserController(LoginService loginService, RegisterService registerService) {
        this.loginService = loginService;
        this.registerService = registerService;
    }

    @PostMapping("/register")
    String register(@RequestBody Map<String, String> requestBody) {
        return registerService.register(requestBody.get("email"), requestBody.get("password"));
    }

    @PostMapping("/login")
    String login(@RequestBody Map<String, String> requestBody) {
        try {
            return loginService.login(requestBody.get("email"), requestBody.get("password"));
        } catch (IllegalArgumentException ex) {
            return "Bad response"; // TODO: Devolver codigo HTTP error
        }
    }

}
