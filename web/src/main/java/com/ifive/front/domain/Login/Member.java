package com.ifive.front.domain.Login;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
@Getter
@Entity
public class Member {  // 스프링 시큐리티에 User가있어서 
    
    @Id
    public String memberId;

    
    public String password;
}
