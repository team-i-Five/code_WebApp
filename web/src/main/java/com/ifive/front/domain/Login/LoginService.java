package com.ifive.front.domain.Login;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    public boolean login(User user);
};
