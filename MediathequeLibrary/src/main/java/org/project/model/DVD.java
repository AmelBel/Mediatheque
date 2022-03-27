package org.project.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.project.controller.UsersViews;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
@Data
public class DVD extends Document {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonView(UsersViews.OneUser.class)
	private String realisateur; 
	
	@NotNull
	@JsonView(UsersViews.OneUser.class)
	private int duree; 
	
	@Enumerated(EnumType.STRING)
	@JsonView(UsersViews.OneUser.class)
	private TypeDVD type;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DVD other = (DVD) obj;
		return duree == other.duree && Objects.equals(realisateur, other.realisateur) && type == other.type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(duree, realisateur, type);
		return result;
	}
}
