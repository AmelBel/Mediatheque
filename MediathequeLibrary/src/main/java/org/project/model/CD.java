package org.project.model;



import java.util.Objects;

import javax.persistence.Entity;

import org.project.controller.UsersViews;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
@Data
public class CD extends Document {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonView(UsersViews.OneUser.class)
	private String artiste_groupe; 
	
	@JsonView(UsersViews.OneUser.class)
	private int duree; 
	
	@JsonView(UsersViews.OneUser.class)
	private int nombreTitre;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CD other = (CD) obj;
		return Objects.equals(artiste_groupe, other.artiste_groupe) && duree == other.duree
				&& nombreTitre == other.nombreTitre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(artiste_groupe, duree, nombreTitre);
		return result;
	}

	

}

