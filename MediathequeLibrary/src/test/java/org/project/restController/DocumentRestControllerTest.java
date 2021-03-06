package org.project.restController;

import org.junit.jupiter.api.Test;
import org.project.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class DocumentRestControllerTest {
	
	@Autowired
	RestTemplate restTemplate; 
	
	@Test 
	public void whenGetDocumentReturn200 () {
		
		Document doc = restTemplate.getForObject("/", Document.class); 
	}

}
