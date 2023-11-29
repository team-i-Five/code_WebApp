package com.ifive.front.domain.Member;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {


    public Member create(String memberName, String email, String password);
};
