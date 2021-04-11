package it.akademy.bbqparty.dao;

import it.akademy.bbqparty.models.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChildDao extends JpaRepository<Child, Integer> {

    List<Child> findAll();



    Child save(Child child);


}
