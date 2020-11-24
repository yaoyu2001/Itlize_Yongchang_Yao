package com.itlize.springsecurityjwt.service;

import com.itlize.springsecurityjwt.models.AuthenticationRequest;

public interface userService {
    public AuthenticationRequest save(AuthenticationRequest authenticationRequest);
}
