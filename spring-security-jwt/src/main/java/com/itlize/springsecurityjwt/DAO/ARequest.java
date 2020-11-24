package com.itlize.springsecurityjwt.DAO;

import com.itlize.springsecurityjwt.models.AuthenticationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ARequest extends JpaRepository<AuthenticationRequest, String > {
}
