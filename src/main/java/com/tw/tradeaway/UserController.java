package com.tw.tradeaway;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public LoginResponse login(@RequestBody Map<String, Object> payload) {
        String email = payload.get("email").toString();
        String token = Base64.getEncoder().encodeToString(email.getBytes(StandardCharsets.UTF_8));
        return new LoginResponse(1,"Santhosh","kumar","email","buyer",token);
    }

}
