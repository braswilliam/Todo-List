package br.com.williamb.dotolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.williamb.dotolist.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{

}
