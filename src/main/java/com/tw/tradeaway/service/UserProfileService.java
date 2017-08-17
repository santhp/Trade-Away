package com.tw.tradeaway.service;

import com.tw.tradeaway.dto.UserProfile;

public interface UserProfileService {

    UserProfile getUserProfile(String email, String password);
}
