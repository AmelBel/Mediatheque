package org.project.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository; 
	
	
	@Test
	void testUpdateUser() {
		
		User userUpdate = userRepository.findById(1l).get(); 
		User userBeforeUpdate = userRepository.findById(1l).get(); 
		
		
		userUpdate.setLogin("nouveau@email.com"); 
		userUpdate.setPassword("newPassword");
		
		userRepository.save(userUpdate); 
		
		assertEquals(userUpdate.getNom(), userBeforeUpdate.getNom());
		assertEquals(userUpdate.getLogin(), "nouveau@email.com");
		
	}
	
	
	

}
