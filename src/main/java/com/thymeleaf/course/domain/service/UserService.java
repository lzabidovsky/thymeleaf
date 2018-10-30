package com.thymeleaf.course.domain.service;

import com.thymeleaf.course.domain.model.dto.UserSignUpRequest;
import com.thymeleaf.course.domain.repository.UserRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
	
	private UserRepository userRepository;

    public void saveUser(UserSignUpRequest request) {
       /* TODO userRepository.save(request)*/
    	if( !request.getPassword().equals(request.getConfirmPassword()) ) {
    		throw new UnsupportedOperationException("Password is not confirmed");
    	}
    	if( userRepository.isSignUp(request.getEmail()) ) {
    		throw new UnsupportedOperationException("User already sign up");
    	}
    	userRepository.save(request);
    }
}
