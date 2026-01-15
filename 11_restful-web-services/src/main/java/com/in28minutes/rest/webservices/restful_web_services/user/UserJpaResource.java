package com.in28minutes.rest.webservices.restful_web_services.user;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restful_web_services.jpa.PostRepository;
import com.in28minutes.rest.webservices.restful_web_services.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController 
class UserJpaResource {
		
	private UserRepository repository;
	private PostRepository postRepository;
	
	public UserJpaResource(UserRepository repository, PostRepository postRepository) {
	    this.repository =  repository;
	    this.postRepository =postRepository;	
	}
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return repository.findAll();
	}
	
//	@GetMapping("/users/{id}")
//	public User retrieveUser(@PathVariable int id){
//		User user  = service.findOne(id);
//		if(user == null)
//			 throw new UserNotFoundException("id:"+id);
//		
//		return user;
//	}

	//Using HATEOAS
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id){
		Optional<User> user  = repository.findById(id);
		if(user.isEmpty())
			 throw new UserNotFoundException("id:"+id);
		
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id){
		 repository.deleteById(id);
	}

	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);
		
		 // Return uri of just created user
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()   //get curretn path
				.path("/{id}")   //add path
				.buildAndExpand(savedUser.getId())  //add the path variable
				.toUri();    //convert to uri
		return ResponseEntity.created(location).build();    //For correct response code
	}
	
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePostsForUser(@PathVariable int id){
		Optional<User> user  = repository.findById(id);
		if(user.isEmpty())
			 throw new UserNotFoundException("id:"+id);
		
		return user.get().getPosts();
	}
	
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostsForUser(@PathVariable int id, @Valid @RequestBody Post post){
		Optional<User> user  = repository.findById(id);
		if(user.isEmpty())
			 throw new UserNotFoundException("id:"+id);
		
		post.setUser(user.get());
		Post savedPost = postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()   //get curretn path
				.path("/{id}")   //add path
				.buildAndExpand(savedPost.getId())  //add the path variable
				.toUri();    //convert to uri
		return ResponseEntity.created(location).build();    //For correct response code
	}

}
