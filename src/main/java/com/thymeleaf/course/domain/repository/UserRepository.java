package com.thymeleaf.course.domain.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.thymeleaf.course.domain.model.dto.UserSignUpRequest;
import com.thymeleaf.course.domain.model.entity.User;

@Repository
public class UserRepository {
	
	private Map<String, User> users = new HashMap<>();
	private Long id = 0L;
	
	public void save(UserSignUpRequest request) {
		User user = new User();
		if( isSignUp(request.getEmail()) ) {
			user.setId( users.get(request.getEmail()).getId() );
		} else {
			user.setId(id++);
		}
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		users.put(request.getEmail(), user);
	}

	public boolean isSignUp(String email) {
		return users.containsKey(email);
	}

}
