package org.project.repository;

import java.util.List;

import org.project.model.CD;
import org.project.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CDRepository extends JpaRepository<CD, Long> {

	

	
}
