package br.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}
