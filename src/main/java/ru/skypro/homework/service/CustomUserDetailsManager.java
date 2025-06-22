package ru.skypro.homework.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.skypro.homework.dto.auth.Register;


public interface CustomUserDetailsManager {

    
    void createUser(UserDetails user, Register register);

    
    boolean userExists(String username);

    
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}