package it.akademy.bbqparty.dao;

import it.akademy.bbqparty.models.Meat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeatDao extends JpaRepository<Meat, Integer> {

    List<Meat> findAll();

    Meat findById(int id);

    Meat save(Meat meat);

    void deleteById(int id);
}
