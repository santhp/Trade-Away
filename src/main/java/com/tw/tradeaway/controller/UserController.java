package com.tw.tradeaway.controller;

import com.tw.tradeaway.dto.UserProfile;
import com.tw.tradeaway.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserProfileService userProfileService;
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<UserProfile> login(@RequestBody Map<String, Object> payload) {

        UserProfile userProfile = userProfileService.getUserProfile((String)payload.get("email"), (String)payload.get("password"));
        if (userProfile == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(userProfile);
    }

}
