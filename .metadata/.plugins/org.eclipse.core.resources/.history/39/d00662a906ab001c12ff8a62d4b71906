package org.project.controller;

import java.util.List;

import org.project.model.Document;
import org.project.model.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mediatheque/catalogue")
public class DocumentRestController {
	
	@Autowired
	private DocumentRepository documentRepository; 
	
	@GetMapping
	public List<Document> findAllDocument () {
		return documentRepository.findAll(); 
		
	}
	
	
	
	

}
