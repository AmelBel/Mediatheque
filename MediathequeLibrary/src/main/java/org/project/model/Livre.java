package org.project.model;

import java.util.Objects;

import javax.persistence.Entity;

import org.project.controller.UsersViews;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Entity
@Data
public class Livre extends Document {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonView(UsersViews.OneUser.class)
	private String ecrivain; 
	
	@JsonView(UsersViews.OneUser.class)
	private long numeroIsbn; //International Standard Book Number 

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livre other = (Livre) obj;
		return Objects.equals(ecrivain, other.ecrivain) && numeroIsbn == other.numeroIsbn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(ecrivain, numeroIsbn);
		return result;
	}
}
