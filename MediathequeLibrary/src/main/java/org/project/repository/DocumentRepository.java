package org.project.repository;

import java.util.List;
import java.util.Optional;

import org.project.model.CD;
import org.project.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface DocumentRepository extends JpaRepository<Document, Long> {
	
	
//	 Rechercher tous les documents deja prédéfit dans la classe de JPARepository 
//	
//   Parcourir le catalogue du stock et visualiser les items disponibles à l’emprunt.
	
	
//   Permettre de voir les nouveautés, uniquement les CD
//	@Query("select * from cd where CURRENT_TIMESTAMP- cd.dataCreation < 7" )
//	public List<CD> findByNewDateCreation (); 
	
	//afficher les documents dont le titre contenant une chaîne particulière
	public Optional<Document> findBytitreContainingIgnoreCase(String chaineTitre); 
	
	
	

}
