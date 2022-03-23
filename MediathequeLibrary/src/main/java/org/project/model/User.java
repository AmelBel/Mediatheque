package org.project.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.project.controller.UsersViews;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
@Data
//@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"login"})})

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(UsersViews.AllUsers.class)
	private long id; 
	
	@NotNull
	@JsonView(UsersViews.AllUsers.class)
	private String login, password;  
	
	@JsonView(UsersViews.AllUsers.class)
	private String nom; 
	@JsonView(UsersViews.AllUsers.class)
	private String prenom;
	
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	@JsonView(UsersViews.OneUser.class)
	private Set<Document> documents = new HashSet<Document>();


	public void effectuerEmprunt(Document document) {
		this.documents.clear(); 
		
	}
	
	public void restituerEmprunt (Document document) {
		
		this.documents.add(document); 
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	} 
	
}
