package org.project.repository;

import org.project.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {

}
