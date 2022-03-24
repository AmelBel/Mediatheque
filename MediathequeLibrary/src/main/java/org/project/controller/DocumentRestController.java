package org.project.controller;

import java.util.List;

import org.project.model.CD;
import org.project.model.DVD;
import org.project.model.Document;
import org.project.model.Livre;
import org.project.repository.CDRepository;
import org.project.repository.DVDRepository;
import org.project.repository.DocumentRepository;
import org.project.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mediatheque/catalogue")
public class DocumentRestController {
	
	@Autowired
	private DocumentRepository documentRepository; 
	
	@Autowired
	private CDRepository cdRepository; 
	
	@Autowired
	private DVDRepository dvdRepository; 
	
	@Autowired
	private LivreRepository livreRepository;  
	
	
	@GetMapping
	public List<Document> findAllDocument () {
		return documentRepository.findAll(); 
		
	}
	
	@GetMapping("/CD")
	public List<CD> findAllCD () {
		return cdRepository.findAll(); 
			
	}
	

	@GetMapping("/Livre")
	public List<Livre> findAllLivre () {
		return livreRepository.findAll(); 	
	}
	
	@GetMapping("/DVD")
	public List<DVD> findAllDvd () {
		return dvdRepository.findAll(); 
	}
	
	
	//afficher les documents dont le titre contenant une chaîne particulière
	// pour tester sur le navigateur : http://localhost:8080/mediatheque/catalogue/search?q=ga, ga c'est la chaine recherché!
	@GetMapping("/search")
	public List<Document>  searchDocumentByString(@RequestParam String q) {
			
			return documentRepository.findBytitreContainingIgnoreCase(q); 
	}
		

	
	

}
