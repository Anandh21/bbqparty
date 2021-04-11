package it.akademy.bbqparty.models;

import javax.persistence.Entity;


@Entity
public class Meat extends Aliment{

    private String animal;

    public Meat() {}

    public Meat( String name, String quantity, String animal) {
        super( name, quantity);
        this.animal = animal;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }
}
