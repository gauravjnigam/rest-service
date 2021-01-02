package com.gn.restsvc.GnRestSvc.user.contoller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.gn.restsvc.GnRestSvc.user.exception.UserNotFoundException;
import com.gn.restsvc.GnRestSvc.user.model.Post;
import com.gn.restsvc.GnRestSvc.user.model.User;

@RestController
public class UserJpaController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@GetMapping(path = "/jpa/users")
	public List<User> retrieveAllUser() {
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/jpa/users/{userId}")
	public User retrieveUser(@PathVariable int userId) {
		Optional<User> findOne = userRepository.findById(userId);
		if(!findOne.isPresent()) {
			throw new UserNotFoundException(String.format("User %d not found" , userId));
		}
		
		// HATEOAS
		// along with User, pass the link to retrieve list of all-user
//		ControllerLinkBuilder.linkTo(methodOn(this.getClass())))
		return findOne.get();
	}
	
	@PostMapping(path = "/jpa/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User saveduser = userRepository.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(path = "/jpa/users/{userId}")
	public void deleteUser(@PathVariable int userId) {
		userRepository.deleteById(userId);
	}
	
	@GetMapping(path = "/jpa/users/{userId}/posts")
	public List<Post> retrieveUserPosts(@PathVariable int userId) {
		Optional<User> findOne = userRepository.findById(userId);
		if(!findOne.isPresent()) {
			throw new UserNotFoundException(String.format("User %d not found" , userId));
		}
		
		User user = findOne.get();
		
		return user.getPosts();
	}
	
	@PostMapping(path = "/jpa/users/{userId}/post")
	public ResponseEntity<Object> saveUser(@PathVariable int userId, @RequestBody Post post) {
		
		Optional<User> findOne = userRepository.findById(userId);
		if(!findOne.isPresent()) {
			throw new UserNotFoundException(String.format("User %d not found" , userId));
		}
		
		User user = findOne.get();
		post.setUser(user);
		
		Post savedPost = postRepository.save(post);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}
