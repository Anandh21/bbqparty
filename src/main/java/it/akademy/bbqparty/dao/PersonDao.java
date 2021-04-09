package it.akademy.bbqparty.dao;

import it.akademy.bbqparty.models.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer> {
    List<Person> findAll();

    Person findByFirstName(String firstname);

    Person save(Person person);

    Person findById(int id);

    void deleteById(int id);
}
