package org.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.project.model.Document;
import org.project.repository.CDRepository;
import org.project.repository.DVDRepository;
import org.project.repository.DocumentRepository;
import org.project.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mediatheque/documents")
public class DocumentRestController {

	@Autowired
	private DocumentRepository documentRepository; 

	@Autowired
	private CDRepository cdRepository; 

	@Autowired
	private DVDRepository dvdRepository; 

	@Autowired
	private LivreRepository livreRepository;  


	//Afficher tous les documents,
	//avec un titre contenant une chaîne particulière
	//avec une date de parution ou avec le type document ( CD/DVD/LIVRE)
	//Pour tester sur le navigateur : http://localhost:8080/mediatheque/catalogue/search?q=ga, ga c'est la chaine recherchée!
	//, @RequestParam Date requestDateParution, @RequestParam String typeDocument
	//	@GetMapping("/search")
	//	public Optional<Document>  searchDocumentByString(@RequestParam String q) {
	//		return documentRepository.findAllByTitreContainingIgnoreCase(q); 
	//		
	//	}
	@GetMapping
	public ResponseEntity<List<Document>> getDocuments(@RequestParam(required = false) String titre, @RequestParam (required = false) Date dateParution, @RequestParam (required = false) String typeDocument) throws ParseException {
		
//		Date dateParution = new SimpleDateFormat("dd-MM-yyyy").parse(sDateParution);
//		System.out.println("DATE : "+ dateParution);
		try {
			List<Document> documents = new java.util.ArrayList<>();
			if (dateParution == null) {

				if (typeDocument == null) 

					if (titre == null)
						documentRepository.findAll().forEach(documents::add);
					else 
						documentRepository.findAllByTitreContainingIgnoreCase(titre).forEach(documents::add); 
				else {

					if (typeDocument.equals("CD")) 
						cdRepository.findAll().forEach(documents::add); 
					if (typeDocument.equals("DVD"))
						dvdRepository.findAll().forEach(documents::add); 
					if (typeDocument.equals("LIVRE"))
						livreRepository.findAll().forEach(documents::add); 
				}
			}
			else 
				documentRepository.findAllByDateParution(dateParution).forEach(documents::add); 

			if (documents.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(documents, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

////  Visualiser les nouveautés, uniquement les CD
//	@GetMapping("/NouveauCD")
//	public ResponseEntity<List<Document>> findAllNewCD () {
//		Date date = new Date(); 
//		
//		date.setMonth(date.getMonth()-1); 
//		
//		try {
//			List<Document> documents = new java.util.ArrayList<>();
//			documentRepository.findByRecentDateParution().forEach(documents::add); 
//			
//	
//			return new ResponseEntity<>(documents, HttpStatus.OK);
//		}
//		catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}


	// ajouter un nouveau document
	@PostMapping
	public Document addDocumentToCatalogue(@RequestBody Document document) {
		documentRepository.save(document); 
		return document; 
	}





}
