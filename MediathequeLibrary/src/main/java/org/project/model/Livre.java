package org.project.model;

import javax.persistence.Entity;

import org.project.controller.UsersViews;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Entity
@Data
public class Livre extends Document {

	@JsonView(UsersViews.OneUser.class)
	private String ecrivain; 
	
	@JsonView(UsersViews.OneUser.class)
	private long numeroIsbn; //International Standard Book Number 
}
