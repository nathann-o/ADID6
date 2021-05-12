package br.edu.ifsp.ADID6.Controller;

import br.edu.ifsp.ADID6.data.vo.PersonVO;
import br.edu.ifsp.ADID6.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices services;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findAll(){
        return services.findAll();
    }

    @RequestMapping("/{id}")
    public PersonVO findById(@PathVariable("id") Long id){
        return services.findById(id);
    }

    @PostMapping
    public PersonVO create(@RequestBody PersonVO person){
        return services.create(person);
    }

    @PutMapping
    public PersonVO update(@RequestBody PersonVO person){
        return services.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        services.delete(id);
        return ResponseEntity.ok().build();
    }

}
