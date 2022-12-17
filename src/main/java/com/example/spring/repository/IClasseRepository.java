package com.example.spring.repository;

import com.example.spring.entites.Classe;
import com.example.spring.entites.Etudiant;
import org.springframework.data.repository.CrudRepository;

public interface IClasseRepository extends CrudRepository<Classe, Long> {
}
