package org.project.repository;

import java.util.List;
import java.util.Optional;

import org.project.model.Emprunt;
import org.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

//	Trouver un user à partir de son ID avec tous les emprunts associés
	 @Query("select u.emprunts from User u where u.id =:id")
	 public List<Emprunt> findAllEmpruntByUserId(@Param("id") Long id);
}
