package org.project.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.project.handlerException.DocumentNotFoundException;
import org.project.handlerException.EmpruntNotFoundException;
import org.project.handlerException.QuotaExceetException;
import org.project.handlerException.ResourceNotAvalaibleException;
import org.project.handlerException.UserNotFoundException;
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
	public Emprunt effectuerEmprunt(User user, List<Document> documents) throws Exception {

		List<Document> documentEmprunt = new ArrayList<>();

		for (Document document : documents) {

			Document dr = documentRepository.findById(document.getId()).orElseThrow(() -> new DocumentNotFoundException()); 
			if (dr.getNombreExemplaire() == 0) {
				throw new ResourceNotAvalaibleException(); 
			}
			dr.setNombreExemplaire(dr.getNombreExemplaire() - 1);
			documentEmprunt.add(dr);
		}
		user = userRepository.findById(user.getId()).orElseThrow(() -> new UserNotFoundException()); 
		int nbDocuments = 0;
		for ( Emprunt emprunt : user.getEmprunts() ) {
			nbDocuments += emprunt.getDocuments().size();
		}
		if (nbDocuments + documents.size() > 3) {
			throw new QuotaExceetException ();
		}
		Emprunt emprunt = new Emprunt();
		emprunt.setDateEmprunt(new Date());
		emprunt.setDateRetour(new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 7)));
		emprunt.setDocuments(documentEmprunt);
		emprunt.setUser(user);

		empruntRepository.save(emprunt);

		for (Document document : documentEmprunt) {
			documentRepository.save(document);
		}
		return emprunt;
	}

	@Override
	public void restituerEmprunt(Emprunt emprunt) throws Exception {

		emprunt = empruntRepository.findById(emprunt.getNumero()).orElseThrow(() -> new EmpruntNotFoundException());
		List<Document> documentEmprunt = emprunt.getDocuments();
		emprunt.setDateRetour(new Date());
		for (Document doc : documentEmprunt) {
			Document dr = documentRepository.findById(doc.getId()).orElseThrow(() -> new DocumentNotFoundException()); 
			dr.setNombreExemplaire(dr.getNombreExemplaire() + 1);
			documentRepository.save(dr);
		}

		empruntRepository.deleteById(emprunt.getNumero());

	}



}
