package it.akademy.bbqparty.controllers;

import it.akademy.bbqparty.dao.AlimentDao;
import it.akademy.bbqparty.models.Aliment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aliments")
public class AlimentController {

    private final AlimentDao alimentDao;

    @Autowired
    public AlimentController(AlimentDao alimentDao)
    {
        this.alimentDao = alimentDao;
    }

    @GetMapping
    public ResponseEntity<List<Aliment>> getAllAliments()
    {
        List<Aliment> aliments = alimentDao.findAll();
        return new ResponseEntity<>(aliments, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Aliment> createAliment(@RequestBody Aliment aliment)
    {
        Aliment addAliment = alimentDao.save(aliment);
        return new ResponseEntity<>(aliment, HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<List<Aliment>> getAllAlimentByName(@PathVariable String name)
    {
        List<Aliment> aliments = alimentDao.findAllByName(name);
        return new ResponseEntity<>(aliments,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAliment(@PathVariable int id)
    {
        Aliment aliment = alimentDao.findById(id);
        if ( aliment == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        alimentDao.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
