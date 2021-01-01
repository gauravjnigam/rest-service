package com.gn.restsvc.GnRestSvc.user.contoller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gn.restsvc.GnRestSvc.user.dao.UserDaoSvc;
import com.gn.restsvc.GnRestSvc.user.exception.UserNotFoundException;
import com.gn.restsvc.GnRestSvc.user.model.User;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoSvc userDaoSvc;

	@GetMapping(path = "/users")
	public List<User> retrieveAllUser() {
		return userDaoSvc.findAll();
	}
	
	@GetMapping(path = "/users/{userId}")
	public User retrieveUser(@PathVariable int userId) {
		User findOne = userDaoSvc.findOne(userId);
		if(findOne == null) {
			throw new UserNotFoundException(String.format("User %d not found" , userId));
		}
		return findOne;
	}
	
	@PostMapping(path = "users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User saveduser = userDaoSvc.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(path = "/users/{userId}")
	public void deleteUser(@PathVariable int userId) {
		User findOne = userDaoSvc.deleteById(userId);
		if(findOne == null) {
			throw new UserNotFoundException(String.format("User %d not found" , userId));
		}
	}
}
