package com.medco.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medco.app.model.request.UserDetailsRequestModel;
import com.medco.app.model.response.UserRest;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

	@GetMapping
	public String getUSer(@RequestParam(defaultValue = "1", value = "page") int page,
			@RequestParam(defaultValue = "50", value = "limit") int limit,
			@RequestParam(required = false, value = "sort", defaultValue = "desc") String sort) {
		return "get User was called with page = " + page + " and limit = " + limit + " and sort = " + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUSer(@PathVariable String userId) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail("johann.medina@valid.com");
		returnValue.setFirstName("Johann");
		returnValue.setLastName("Medina");
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
		// return "get User was called with userId = " + userId;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
		// return "get User was called with userId = " + userId;
	}

	@PutMapping
	public String updateUser() {
		return "update user was called";
	}

	@DeleteMapping
	public String deleteUser() {
		return "delete User was called";
	}

}
