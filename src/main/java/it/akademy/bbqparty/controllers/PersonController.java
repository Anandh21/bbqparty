package it.akademy.bbqparty.controllers;

import it.akademy.bbqparty.dao.AlimentDao;
import it.akademy.bbqparty.dao.PersonDao;
import it.akademy.bbqparty.models.Aliment;
import it.akademy.bbqparty.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {
    private final PersonDao personDao;
    private final AlimentDao alimentDao;
    @Autowired

    public PersonController(PersonDao personDao, AlimentDao alimentDao) {
        this.personDao = personDao;
        this.alimentDao = alimentDao;
    }
    @GetMapping
    public ResponseEntity<List<Person>> getAllPeople()
    {
        List<Person> people = personDao.findAll();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person person)
    {
        Person addPerson = personDao.save(person);
        return new ResponseEntity<>(addPerson, HttpStatus.CREATED);
    }
    @GetMapping("/{firstName}")
    public ResponseEntity<Person> findPersonByFirstName(@PathVariable String firstName)
    {
        Person person = personDao.findByFirstName(firstName);
        if(person == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id,@RequestBody Person person)
    {
        Person updatedPerson = personDao.findById(id);
        if (updatedPerson == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        person.setId(id);
        updatedPerson = personDao.save(person);
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable int id)
    {
        Person person = personDao.findById(id);
        if(person == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        personDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{personId}/aliments/{alimentId}")
    public ResponseEntity<Person> addAlimentInPerson(@PathVariable int personId, @PathVariable int alimentId)
    {
        Person person = personDao.findById(personId);
        if (person == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Aliment aliment = alimentDao.findById(alimentId);
        if(aliment == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        person.getAliments().add(aliment);
        aliment.setPerson(person);
        person.setId(personId);
        personDao.save(person);
        return new ResponseEntity<>(person,HttpStatus.OK);
    }

}
