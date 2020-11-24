package com.itlize.springsecurityjwt.service;

import com.itlize.springsecurityjwt.DAO.ARequest;
import com.itlize.springsecurityjwt.models.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    ARequest aRequest;

//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return new User("yang", passwordEncoder.encode("12345678"),
//                new ArrayList<>());
//    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<AuthenticationRequest> user = aRequest.findById(s);
        if (user == null){
            throw new UsernameNotFoundException("User not find by the username");
        }else{
            return new org.springframework.security.
                    core.userdetails.User(user.get().getUsername(),
                    passwordEncoder.encode(user.get().getPassword()), new ArrayList<>());
    }

    }



    }

