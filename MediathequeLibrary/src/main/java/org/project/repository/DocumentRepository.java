package org.project.repository;

import java.util.Date;
import java.util.List;

import org.project.model.CD;
import org.project.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
	
	
//	 Rechercher tous les documents deja prédéfit dans la classe de JPARepository 
//	
//   Parcourir le catalogue du stock et visualiser les items disponibles à l’emprunt.
	
	
	//afficher les documents dont le titre contenant une chaîne particulière
	public List<Document> findAllByTitreContainingIgnoreCase(String chaineTitre); 

	//afficher les documents par date parution
	public List<Document> findAllByDateParution(Date dateParution);
	
	//  Visualiser les nouveautés, uniquement les CD
//	@Query("select d from document d where d.dateParution> ?1")
//	public List<Document> findByRecentDateParution(Date date); 

	

}
