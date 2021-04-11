package it.akademy.bbqparty.models;

import javax.persistence.Entity;

@Entity
public class Child extends Person{

    private int nbrOfChildren;

    public Child(){}

    public Child(String lastName, String firstName, Barbecue barbecue, String phone, int nbrOfChildren) {
        super(lastName, firstName, barbecue, phone);
        this.nbrOfChildren = nbrOfChildren;
    }

    public int getNbrOfChildren() {
        return nbrOfChildren;
    }

    public void setNbrOfChildren(int nbrOfChildren) {
        this.nbrOfChildren = nbrOfChildren;
    }
}
