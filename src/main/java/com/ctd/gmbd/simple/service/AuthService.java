package com.ctd.gmbd.simple.service;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctd.gmbd.simple.repository.AuthRepository;
import com.ctd.gmbd.simple.repository.AuthUserEntity;

@Service
public class AuthService {

    private final AuthRepository userRepository;

    // Constructor injection is the best practice
    public AuthService(AuthRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public AuthUserEntity createAndSaveUser(String name) {
    	try {
	        AuthUserEntity user = new AuthUserEntity();
	        user.setName(name);
	        
	        // This performs the INSERT INTO users (name) VALUES (?)
	        return userRepository.save(user);
    	} catch(ConstraintViolationException e) {
    		System.out.println("Name: " + name + " already exists");
    		throw e;
    	}
    }
}