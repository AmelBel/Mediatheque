package org.project.model;

import javax.persistence.Entity;

import org.project.controller.UsersViews;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
@Data
public class CD extends Document {
	
	@JsonView(UsersViews.OneUser.class)
	private String artiste_groupe; 
	
	@JsonView(UsersViews.OneUser.class)
	private int duree; 
	
	@JsonView(UsersViews.OneUser.class)
	private int nombreTitre; 
	
	

}

