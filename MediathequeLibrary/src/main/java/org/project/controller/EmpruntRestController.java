package org.project.controller;

import java.util.List;

import org.project.handlerException.EmpruntNotFoundException;
import org.project.handlerException.UserNotFoundException;
import org.project.model.Document;
import org.project.model.Emprunt;
import org.project.model.User;
import org.project.repository.EmpruntRepository;
import org.project.repository.UserRepository;
import org.project.service.IMediatheque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mediatheque")
public class EmpruntRestController {
	@Autowired
	private IMediatheque iMediatheque;
	@Autowired
	private EmpruntRepository empruntRepository;
	@Autowired
	private UserRepository userRepository;
	

	@PostMapping("/emprunts/{id_user}")
	public Emprunt effectuerEmprunt(@PathVariable Long id_user,@RequestBody List<Document> documents) throws Exception {
		User user = userRepository.findById(id_user).orElseThrow(() -> new UserNotFoundException());
		user.setId(id_user); 
		return iMediatheque.effectuerEmprunt(user, documents);
	}

	@DeleteMapping("/emprunts/{id_Emprunt}")
	public void restituerEmprunt(@PathVariable Long  id_Emprunt) throws Exception {
		Emprunt emprunt = empruntRepository.findById(id_Emprunt).orElseThrow(() -> new EmpruntNotFoundException ()); 
		emprunt.setNumero(id_Emprunt); 
		iMediatheque.restituerEmprunt(emprunt);
	} 
	

}
