package org.project.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.project.model.Document;
import org.project.model.Emprunt;
import org.project.model.User;
import org.project.repository.DocumentRepository;
import org.project.repository.EmpruntRepository;
import org.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MediathequeServiceImplement implements IMediatheque {
	@Autowired
	private DocumentRepository documentRepository; 

	@Autowired
	private EmpruntRepository empruntRepository; 
	
	@Autowired
	private UserRepository userRepository; 

	@Override
	public List<Document> consulterDocument() {

		return documentRepository.findAll();
	}

	@Override
	public Emprunt effectuerEmprunt (User user, List<Document> documents) throws Exception {
		
	        List<Document> documentEmprunt = new ArrayList<>();
	        
	        for (Document document : documents) {
	        	
	            Document dr = documentRepository.findById(document.getId()).orElseThrow(() -> new Exception());
	            if (dr.getNombreExemplaire() == 0) {
	                throw new Exception();
	            }
	            dr.setNombreExemplaire(dr.getNombreExemplaire()-1);
	            documentEmprunt.add(dr);
	        }
	 
	            Emprunt emprunt = new Emprunt(); 
	            emprunt.setDateEmprunt(new Date());
	            emprunt.setDocuments(documentEmprunt);
	            emprunt.setUser(user);
	        
	         
	            if(user.getEmprunts().size() < 3) {
	                empruntRepository.save(emprunt);
	            } else {
	                throw new Exception();
	            }
	            for ( Document document : documentEmprunt ) {
	               documentRepository.save(document);
	            }
	 
	        
	        return emprunt;
	    }
		
		

	@Override
	public void restituerEmprunt(User user, Emprunt emprunt) {
		List<Document> documents = consulterDocument();  

		for (Document docDisponible: documents) {
			for (Document docEmprunter: emprunt.getDocuments() ) {
				if ((docDisponible.getId()== docEmprunter.getId())) {
					docDisponible.setNombreExemplaire(docDisponible.getNombreExemplaire()+1);
				}
			}
		}

		empruntRepository.save(emprunt); 
	}

//	@Override
//	public List<Emprunt> visualiserEmprunt(User user, Emprunt emprunt) {
//		
//		return empruntRepository.visualiserEmprunt(user, emprunt); 
//	}

}
