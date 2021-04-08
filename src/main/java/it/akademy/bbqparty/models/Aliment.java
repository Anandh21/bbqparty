package it.akademy.bbqparty.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


@Entity
public class Aliment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;

    @JsonBackReference
    @ManyToOne
    private Person person;

    @JsonBackReference
    @ManyToOne
    private Barbecue barbecue;




}
