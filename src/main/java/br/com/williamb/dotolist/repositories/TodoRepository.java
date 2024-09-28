package br.com.williamb.dotolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.williamb.dotolist.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{

}
