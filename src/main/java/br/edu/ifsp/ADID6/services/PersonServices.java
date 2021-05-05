package br.edu.ifsp.ADID6.services;

import br.edu.ifsp.ADID6.exeption.ResourceNotFoundException;
import br.edu.ifsp.ADID6.model.Person;
import br.edu.ifsp.ADID6.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    public Person create(Person person){
        return repository.save(person);
    }

    public Person update(Person person){
        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id){
        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));

        repository.delete(entity);
    }

    public Person findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));
    }

    public List<Person> findAll(){
        return repository.findAll();
    }
}
