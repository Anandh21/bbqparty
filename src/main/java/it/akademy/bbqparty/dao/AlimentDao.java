package it.akademy.bbqparty.dao;

import it.akademy.bbqparty.models.Aliment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface AlimentDao extends JpaRepository<Aliment, Integer> {

    List<Aliment> findAll();

    List<Aliment> findAllByName(String name);

    Aliment findById(int id);

    Aliment save(Aliment aliment);

    void deleteById(int id);
}
