package com.medco.app.service;

import com.medco.app.model.request.UserDetailsRequestModel;
import com.medco.app.model.response.UserRest;

public interface UserService {

	UserRest createUser(UserDetailsRequestModel userDetails);

}
