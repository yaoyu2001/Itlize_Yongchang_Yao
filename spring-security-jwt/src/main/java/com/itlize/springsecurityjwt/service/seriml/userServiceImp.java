package com.itlize.springsecurityjwt.service.seriml;

import com.itlize.springsecurityjwt.DAO.ARequest;
import com.itlize.springsecurityjwt.models.AuthenticationRequest;
import com.itlize.springsecurityjwt.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImp implements userService {

    @Autowired
    ARequest aRequest;


    @Override
    public AuthenticationRequest save( AuthenticationRequest authenticationRequest ) {
        return aRequest.save(authenticationRequest);
    }
}
