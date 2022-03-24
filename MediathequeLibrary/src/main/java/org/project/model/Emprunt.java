package org.project.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Emprunt {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numero; 
	private Date dateEmprunt; 
	private Date dateRetour; 
	
	
	@ManyToOne
	private User user; 
	
	@OneToMany
	private List<Document> documents;

	public Emprunt(long numero, Date dateEmprunt, Date dateRetour, User user, List<Document> documents) {
		super();
		this.numero = numero;
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
		this.user = user;
		this.documents = documents;
	}

	public Emprunt(User user, List<Document> documents) {
		super();
		this.user = user;
		this.documents = documents;
	} 
	
	


	
}
