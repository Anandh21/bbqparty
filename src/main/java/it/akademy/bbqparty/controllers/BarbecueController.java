package it.akademy.bbqparty.controllers;

import it.akademy.bbqparty.dao.AlimentDao;
import it.akademy.bbqparty.dao.BarbecueDao;
import it.akademy.bbqparty.dao.PersonDao;
import it.akademy.bbqparty.models.Aliment;
import it.akademy.bbqparty.models.Barbecue;
import it.akademy.bbqparty.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barbecues")
public class BarbecueController {
    private final BarbecueDao barbecueDao;
    private final PersonDao personDao;
    private final AlimentDao alimentDao;



    @Autowired

    public BarbecueController(BarbecueDao barbecueDao, PersonDao personDao, AlimentDao alimentDao) {
        this.barbecueDao = barbecueDao;
        this.personDao = personDao;
        this.alimentDao = alimentDao;
    }

    @GetMapping
    public ResponseEntity<List<Barbecue>> getAllBarbecue()
    {
        List<Barbecue> barbecues = barbecueDao.findAll();
        return new ResponseEntity<>(barbecues, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Barbecue> addBarbecue(@RequestBody Barbecue barbecue)
    {
        Barbecue addBarbecue = barbecueDao.save(barbecue);
        return new ResponseEntity<>(addBarbecue, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Barbecue> update(@PathVariable int id, @RequestBody Barbecue barbecue){
        Barbecue updatedBarbecue = barbecueDao.findById(id);

        if(updatedBarbecue == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        barbecue.setId(id);
        updatedBarbecue = barbecueDao.save(barbecue);
        return new ResponseEntity<>(updatedBarbecue, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barbecue> getBarbecueById(@PathVariable int id)
    {
        Barbecue barbecue = barbecueDao.findById(id);
        if (barbecue == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(barbecue,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBarbecue(@PathVariable int id)
    {
        Barbecue barbecue = barbecueDao.findById(id);
        if (barbecue == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        barbecueDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{barbecueId}/people/{personId}")
    public ResponseEntity<Barbecue> addPersonInBarbecue(@PathVariable int barbecueId, @PathVariable int personId)
    {
        Barbecue barbecue = barbecueDao.findById(barbecueId);
        if (barbecue == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Person person = personDao.findById(personId);
        if (person == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        barbecue.getPersons().add(person);
        person.setBarbecue(barbecue);
        barbecue.setId(barbecueId);
        barbecueDao.save(barbecue);
        return new ResponseEntity<>(barbecue,HttpStatus.OK);
    }
    @PutMapping("/{barbecueId}/aliments/{alimentId}")
    public ResponseEntity<Barbecue> addAlimentInBarbecue(@PathVariable int barbecueId, @PathVariable int alimentId)
    {
        Barbecue barbecue = barbecueDao.findById(barbecueId);
        if (barbecue == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Aliment aliment = alimentDao.findById(alimentId);
        if (aliment == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        barbecue.getAliments().add(aliment);
        aliment.setBarbecue(barbecue);
        barbecue.setId(barbecueId);
        barbecueDao.save(barbecue);
        return new ResponseEntity<>(barbecue, HttpStatus.OK);
    }



}
