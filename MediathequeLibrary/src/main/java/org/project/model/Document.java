package org.project.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;
import org.project.controller.UsersViews;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy=InheritanceType.JOINED) 

//@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
//@JsonSubTypes({
//	@Type(name="CD", value=CD.class),
//	@Type(name="DVD", value=DVD.class),
//	@Type(name="LIVRE", value=Livre.class),
//})
public class Document implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6590486482810196501L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(UsersViews.OneUser.class)
	private long id; 
	
	@JsonView(UsersViews.OneUser.class)
	private String titre; 
	
	@JsonView(UsersViews.OneUser.class)
	private int nombreExemplaire; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonView(UsersViews.OneUser.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateParution; 
	
	@ManyToMany(mappedBy="documents", fetch = FetchType.LAZY)
	@JsonIgnore 
	private Set<Emprunt> emprunts = new HashSet<Emprunt>();
	
	
	
	@PrePersist
	private void onCreate() {
		dateParution = new Date(); 
		
	}


}
