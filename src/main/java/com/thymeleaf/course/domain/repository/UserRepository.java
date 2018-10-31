package com.thymeleaf.course.domain.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.thymeleaf.course.domain.model.entity.User;

@Repository
public class UserRepository {
	
	private Map<String, User> users = new HashMap<>();
	private Long id = 0L;
	
	public void save(User user) {
		user.setId(id++);
		users.put(user.getEmail(), user);
	}

	public boolean isSignUp(String email) {
		return users.containsKey(email);
	}

}
