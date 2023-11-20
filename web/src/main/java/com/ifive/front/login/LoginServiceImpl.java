package com.ifive.front.login;

import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl {
    private final UserRepository userRepository;
    
    @Autowired
    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean login(User user) {
        User findUser = userRepository.findByUserId(user.getUserId());

        if(findUser == null) {
            return false;
        }
        if(!findUser.getPassword().equals(user.getPassword())){
            return false;
        }

        return true;
    }
}
