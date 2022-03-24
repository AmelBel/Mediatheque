package org.project.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.project.model.Document;
import org.project.model.Emprunt;
import org.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MediathequeServiceTest {


	@Autowired
	IMediatheque mediathequeService;


	@Test
	public void whenAllIsOkEmpruntIsCreated() throws Exception {

		User user2 = new User();
		user2.setId(1l);

		List<Document> docs = new ArrayList<>();
		Document doc1 = new Document();
		doc1.setId(1l);
		Document doc2 = new Document();
		doc2.setId(2l);
		docs.add(doc1);
		docs.add(doc2);

		Emprunt emprunt = mediathequeService.effectuerEmprunt(user2, docs);

		assertNotNull(emprunt.getNumero());
		assertTrue(emprunt.getDocuments().size() == 2);
	}

	@Test
	public void whenQuotaExceedThrowException() {
		User user1 = new User();
		user1.setId(1l);

		List<Document> docs = new ArrayList<>();
		Document doc1 = new Document();
		doc1.setId(1l);
		Document doc2 = new Document();
		doc2.setId(12);
		docs.add(doc1);
		docs.add(doc2);

		try {
			Emprunt emprunt = mediathequeService.effectuerEmprunt(user1, docs);
			fail();
		} catch (Exception e) {
			System.out.println("OK");
		}



	}

}
