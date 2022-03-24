package org.project.service;

import java.util.List;

import org.project.model.Document;
import org.project.model.Emprunt;
import org.project.model.User;

public interface IMediatheque {

	
	public Emprunt effectuerEmprunt(User user, List<Document> documents) throws Exception;  
	public void restituerEmprunt(User user,  Emprunt emprunt); 
//	public List<Emprunt> visualiserEmprunt(User user,  Emprunt emprunt); 
	
}
