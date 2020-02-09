package com.medco.app.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medco.app.model.request.UserDetailsRequestModel;
import com.medco.app.model.response.UserRest;
import com.medco.app.service.UserService;
import com.medco.app.util.Utils;

@Service
public class UserServiceImpl implements UserService {
	Utils utils;
	private Map<String, UserRest> users;

	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		String userId = utils.generateUserId();
		returnValue.setUserId(userId);
		if (users == null)
			users = new HashMap<String, UserRest>();
		users.put(userId, returnValue);
		return returnValue;
	}

	// CONSTRUCTORS
	public UserServiceImpl() {
		super();
	}

	@Autowired
	public UserServiceImpl(Utils utils) {
		super();
		this.utils = utils;
	}
}
