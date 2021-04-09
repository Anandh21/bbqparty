package it.akademy.bbqparty.dao;

import it.akademy.bbqparty.models.Barbecue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarbecueDao extends JpaRepository<Barbecue, Integer> {
    List<Barbecue> findAll();

    Barbecue findById(int id);

    Barbecue save(Barbecue barbecue);

    void deleteById(int id);
}
