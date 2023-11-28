package com.ifive.front.domain.Login;

import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl {
    private final MemberRepository userRepository;
    
    @Autowired
    public LoginServiceImpl(MemberRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean login(Member member) {
        Member findUser = userRepository.findByMemberId(member.getMemberId());

        if(findUser == null) {
            return false;
        }
        if(!findUser.getPassword().equals(member.getPassword())){
            return false;
        }

        return true;
    }
}
