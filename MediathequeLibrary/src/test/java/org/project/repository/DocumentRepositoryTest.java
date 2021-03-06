package org.project.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Date;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.project.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class DocumentRepositoryTest {
	
	@Autowired
	DocumentRepository documentRepository; 
	
	
	
//	@Test 
//	void testByContainingTitreIgnoringCase() {
//		
//		Optional<Document> found = documentRepository.findAllByTitreContainingIgnoreCase("DOCUMENT1"); 
//		
//		assertTrue(found.isPresent());
//		
//		Optional<Document> notFound = documentRepository.findAllByTitreContainingIgnoreCase("notfound"); 
//		
//		assertTrue(!notFound.isPresent());
//				
//	}
//	
	@Test 
	void testAddDocument () {
		
		long intialDocumentCount = documentRepository.count(); 
		
		Document newDocument = new Document(); 
		newDocument.setTitre("NewTitle");
		newDocument.setDateParution(new Date());
		newDocument.setNombreExemplaire(20);
		
		documentRepository.save(newDocument); 
		
		assertEquals(intialDocumentCount +1, documentRepository.count());
				
		
	}
	

}
