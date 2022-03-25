package org.project.controller;

import java.util.List;

import org.project.model.Document;
import org.project.model.Emprunt;
import org.project.model.User;
import org.project.service.IMediatheque;
import org.project.service.MediathequeServiceImplement;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mediatheque")
public class EmpruntRestController {
	
	private IMediatheque iMediatheque;

	@PutMapping("/Emprunter")
	public Emprunt effectuerEmprunt(@RequestParam User user,@RequestParam List<Document> documents) throws Exception {
		return iMediatheque.effectuerEmprunt(user, documents);
	}

	@DeleteMapping("/Restituer")
	public void restituerEmprunt(@RequestParam User user,@RequestParam Emprunt emprunt) throws Exception {
		iMediatheque.restituerEmprunt(user, emprunt);
	} 
	

}
