package org.project.service;

import java.util.List;

import org.project.model.Document;
import org.project.model.DocumentRepository;
import org.project.model.Emprunt;
import org.project.model.EmpruntRepository;
import org.project.model.User;
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

	@Override
	public List<Document> consulterDocument() {

		return documentRepository.findAll();
	}

	@Override
	public void effectuerEmprunt(User user, Emprunt emprunt) {
		List<Document> documents = consulterDocument();  

		for (Document docDisponible: documents) {
			for (Document docEmprunter: emprunt.getDocuments() ) {
				if ((docDisponible.getId()== docEmprunter.getId()) && docEmprunter.getNombreExemplaire()> 0) {
					docDisponible.setNombreExemplaire(docDisponible.getNombreExemplaire()-1);
				}
			}
		}

		empruntRepository.save(emprunt); 


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