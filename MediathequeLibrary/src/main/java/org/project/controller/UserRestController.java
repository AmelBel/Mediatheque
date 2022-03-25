package org.project.controller;


import java.util.List;

import org.project.model.Emprunt;
import org.project.model.User;
import org.project.repository.EmpruntRepository;
import org.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/mediatheque/users")
public class UserRestController {

	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private EmpruntRepository empruntRepository; 

	@GetMapping
	@JsonView(UsersViews.AllUsers.class)
	public List<User> findAllUser() {
		return userRepository.findAll(); 
	}

	@GetMapping("/{id_user}")
	@JsonView(UsersViews.OneUser.class)
	public User findOne(@PathVariable Long id_user) throws UserNotFountException {
		return userRepository.fullLoad(id_user).orElseThrow(() -> new UserNotFountException()); 
	}

	//Créer un user
	@PostMapping
	@JsonView(UsersViews.OneUser.class)
	public ResponseEntity<User> saveUser(@RequestBody User user) {		
		user = userRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED); 
	} 

	//Mettre à jour d'un user
	@PutMapping
	@JsonView(UsersViews.OneUser.class)
	public User upDateUser(@RequestBody User user) throws UserNotFountException {
		userRepository.findById(user.getId()).orElseThrow(() -> new UserNotFountException());
		userRepository.save(user); 
		return user;
	}
	
	
	// Visualiser les emprunts d'un utilisateur
		@GetMapping("/{id_user}/Emprunts")
		@JsonView(UsersViews.OneUser.class)
		public List<Emprunt> findAllEmpruntByUserId(@PathVariable Long id_user) throws UserNotFountException {
			userRepository.findById(id_user).orElseThrow(() -> new UserNotFountException()); 
			return empruntRepository.findAllEmpruntByUserId(id_user); 		
		}
	
}
