package org.project.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

public interface DocumentRepository extends JpaRepository<Document, Long> {
	
	
//	 Rechercher tous les documents deja prédéfit dans la classe de JPARepository 
//	
//   Parcourir le catalogue du stock et visualiser les items disponibles à l’emprunt.
	

	
//   Permettre de voir les nouveautés, uniquement les CD
	

}
