package br.edu.ifsp.ADID6.services;

import br.edu.ifsp.ADID6.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();

    public Person findById(String id){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Nathann");
        person.setLastName("Oliveira");
        person.setAddress("Avenida Salgado Filho, 3501 - Vila Rio de Janeiro");
        person.setGender("Male");
        return person;
    }

    public List<Person> findAll(){
        List<Person> persons = new ArrayList<Person>();
        for (int i=0 ; i<10 ; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Nome " + i);
        person.setLastName("Sobrenome " + i);
        person.setAddress("Endereço pessoa " + i);
        person.setGender("Male");
        return person;
    }
}
