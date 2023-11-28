package com.ifive.front.domain.Member;

import org.springframework.stereotype.Service;

@Service
public interface IfiveMemberService {


    public IfiveMember create(String memberName, String email, String password);
};
