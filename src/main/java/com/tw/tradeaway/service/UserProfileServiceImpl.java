package com.tw.tradeaway.service;

import com.tw.tradeaway.dao.UserDAO;
import com.tw.tradeaway.dto.UserProfile;
import com.tw.tradeaway.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserDAO userDAO;
    @Override
    public UserProfile getUserProfile(String email, String password) {

        User user = userDAO.getUser(email,password);
        if (user == null)
            return null;
        System.out.println("DBG:  " + user);
        String token = Base64.getEncoder().encodeToString(user.getEmailId().getBytes(StandardCharsets.UTF_8));
        return new UserProfile(user.getId(), user.getFirstName(), user.getLastName(), user.getEmailId(), user.getRole(), token);
    }
}
