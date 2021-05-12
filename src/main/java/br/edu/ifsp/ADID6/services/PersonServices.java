package br.edu.ifsp.ADID6.services;

import br.edu.ifsp.ADID6.converter.DozerConverter;
import br.edu.ifsp.ADID6.data.vo.PersonVO;
import br.edu.ifsp.ADID6.exeption.ResourceNotFoundException;
import br.edu.ifsp.ADID6.data.model.Person;
import br.edu.ifsp.ADID6.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    public PersonVO create(PersonVO person){
        var entity = DozerConverter.parseObject(person, Person.class);
        var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO update(PersonVO person){
        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id){
        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));

        repository.delete(entity);
    }

    public PersonVO findById(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontramos registros para este ID"));
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAll(){
        return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
    }
}
