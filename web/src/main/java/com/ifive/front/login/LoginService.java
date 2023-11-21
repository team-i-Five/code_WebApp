package com.ifive.front.login;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    public boolean login(User user);
};
