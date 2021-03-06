package org.project.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user; 
	
	@ManyToMany
	@JoinColumn(name="documents_id")
	@JsonView(EmpruntViews.OneEmprunt.class)	
	//@JsonIgnore
	private List<Document> documents;


	
}
