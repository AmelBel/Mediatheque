package org.project.repository;


import java.util.Optional;

import org.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {


//	CRUD sur users et documents dèja surchargé en JPARepository
	
	
//	Trouver un user pour un login et un mot de passe donné
	public User findByLoginAndPassword(String login, String password); 
	

//	Compter les membres deja prédéfit dans la classe JPARepository

	
//	Trouver un user à partir de son ID avec tous les emprunts associés pré-chargés

    @Query("from User u left join fetch u.emprunts where u.id =:id")
    public Optional<User> fullLoad(Long id);

    
 // sauvegarder un client 
   // public User saveUser(User user); 
    
    
	
}