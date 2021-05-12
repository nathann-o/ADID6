package br.edu.ifsp.ADID6.repository;

import br.edu.ifsp.ADID6.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
