package com.market.service;

import com.market.model.User;
import com.market.model.UserResult;
import org.springframework.stereotype.Service;


@Service
public interface LogAndSignService {
    UserResult login(User user);
    UserResult signUp(User user);
}

