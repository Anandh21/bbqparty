package it.akademy.bbqparty.controllers;


import it.akademy.bbqparty.dao.MeatDao;
import it.akademy.bbqparty.models.Meat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/meats")
@RestController
public class MeatController {

    private final MeatDao meatDao;

    public MeatController(MeatDao meatDao)
    {
        this.meatDao = meatDao;
    }

    @GetMapping
    public ResponseEntity<List<Meat>> getAllMeat()
    {
        List<Meat> meats = meatDao.findAll();

        return new ResponseEntity<>(meats, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Meat> addMeat(@RequestBody Meat meat)
    {
        meatDao.save(meat);
        return new ResponseEntity<>(meat, HttpStatus.CREATED);
    }
}
