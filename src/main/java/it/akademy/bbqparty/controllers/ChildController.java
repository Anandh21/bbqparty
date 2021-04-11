package it.akademy.bbqparty.controllers;

import it.akademy.bbqparty.dao.ChildDao;
import it.akademy.bbqparty.models.Child;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/people/children")
@RestController
public class ChildController {

    private final ChildDao childDao;

    public ChildController(ChildDao childDao) {
        this.childDao = childDao;
    }

    @GetMapping
    public ResponseEntity<List<Child>> getAllChild()
    {
        List<Child> children = childDao.findAll();
        return new ResponseEntity<>(children, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Child> addChild(@RequestBody Child child)
    {
        childDao.save(child);
        return  new ResponseEntity<>(child, HttpStatus.CREATED);
    }
}
