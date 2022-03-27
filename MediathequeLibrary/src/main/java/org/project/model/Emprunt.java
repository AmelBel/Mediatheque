package org.project.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.project.controller.EmpruntViews;
import org.project.controller.UsersViews;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
@Data
public class Emprunt implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6590486482810196501L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(UsersViews.OneUser.class)
	private long numero; 
	@JsonView(UsersViews.OneUser.class)
	private Date dateEmprunt; 
	@JsonView(UsersViews.OneUser.class)
	private Date dateRetour; 
	
	
	@ManyToOne
	@JsonIgnore
	private User user; 
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	@JsonView(EmpruntViews.OneEmprunt.class)	
	private List<Document> documents;

	


	
}
