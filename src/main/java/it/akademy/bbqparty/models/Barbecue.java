package it.akademy.bbqparty.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Barbecue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date date;

    private String city;

    @JsonManagedReference(value = "barbecue-person")
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Person> persons;

    @JsonManagedReference(value = "barbecue-aliment")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aliment> aliments;
    public Barbecue(){}

    public Barbecue(Date date, String city, List<Person> persons, List<Aliment> aliments) {
        this.date = date;
        this.city = city;
        this.persons = persons;
        this.aliments = aliments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Aliment> getAliments() {
        return aliments;
    }

    public void setAliments(List<Aliment> aliments) {
        this.aliments = aliments;
    }
}
