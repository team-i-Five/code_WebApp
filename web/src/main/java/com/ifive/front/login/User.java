package com.ifive.front.login;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
public class User {
    @Id
    public String userId;

    
    public String password;
}
