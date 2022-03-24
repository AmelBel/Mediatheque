package org.project.repository;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.project.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class DocumentRepositoryTest {
	
	@Autowired
	DocumentRepository documentRepository; 
	
	
	
	@Test 
	void testByContainingTitreIgnoringCase() {
		
		Optional<Document> found = documentRepository.findBytitreContainingIgnoreCase("Formidable"); 
		
		assertTrue(found.isPresent());
		
		Optional<Document> notFound = documentRepository.findBytitreContainingIgnoreCase("notfound"); 
		
		assertTrue(!notFound.isPresent());
				
	}
	

}
