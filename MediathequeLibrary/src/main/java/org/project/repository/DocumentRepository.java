package org.project.repository;

import java.util.List;

import org.project.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface DocumentRepository extends JpaRepository<Document, Long> {
	
	
//	 Rechercher tous les documents deja prédéfit dans la classe de JPARepository 
//	
//   Parcourir le catalogue du stock et visualiser les items disponibles à l’emprunt.
	
	
//   Permettre de voir les nouveautés, uniquement les CD
	
	//afficher les documents dont le titre contenant une chaîne particulière
	public List<Document> findBytitreContainingIgnoreCase(String chaineTitre); 
	
	

}