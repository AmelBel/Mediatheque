package org.project.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.project.controller.UsersViews;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
@Data
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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


	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true, mappedBy = "user")// Merge: il traite que les mises à jours
	//@OneToMany(mappedBy = "user")
	@JsonView(UsersViews.OneUser.class)
	private Set<Emprunt> emprunts = new HashSet<Emprunt>();
	//	private List<Emprunt> emprunts = new ArrayList<Emprunt>();
	
	
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
