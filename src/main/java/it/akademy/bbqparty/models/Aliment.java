package it.akademy.bbqparty.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


@Entity
public class Aliment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String quantity;

    @JsonBackReference(value = "person-aliment" )
    @ManyToOne
    private Person person;

    @JsonBackReference(value = "barbecue-aliment")
    @ManyToOne
    private Barbecue barbecue;

    public Aliment(){}

    public Aliment(int id, String name, String quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
    public int getId()
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Barbecue getBarbecue() {
        return barbecue;
    }

    public void setBarbecue(Barbecue barbecue) {
        this.barbecue = barbecue;
    }
}
