package br.edu.ifsp.ADID6.converter.mocks;

import br.edu.ifsp.ADID6.data.model.Person;
import br.edu.ifsp.ADID6.data.vo.PersonVO;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {

    public Person mockEntity(){
        return mockEntity(0);
    }

    public PersonVO mockVO(){
        return mockVO(0);
    }

    public List<Person> mockEntityList(){
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++){
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonVO> mockVOList(){
        List<PersonVO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++){
            persons.add(mockVO(i));
        }
        return persons;
    }

    private Person mockEntity(Integer number){
        Person person = new Person();
        person.setAddress("Address test" + number);
        person.setFirstName("First name test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last name test" + number);
        return person;
    }

    private PersonVO mockVO(Integer number){
        PersonVO person = new PersonVO();
        person.setAddress("Address test" + number);
        person.setFirstName("First name test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last name test" + number);
        return person;
    }

}
