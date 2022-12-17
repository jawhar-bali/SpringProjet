package com.example.spring.services;

import com.example.spring.entites.Etudiant;
import lombok.AllArgsConstructor;
import com.example.spring.entites.Projet;
import com.example.spring.repository.IProjetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetService implements IProjet{
    private final IProjetRepository projetRepository;
    @Override
    public List<Projet> retrieveAllProjet() {
        return (List<Projet>) projetRepository.findAll();
    }
    @Override
    public Projet addProjet(Projet p) {
        return  projetRepository.save(p);
    }
    @Override
    public Projet updateProjet(Projet p) {
        return projetRepository.save(p);
    }
    @Override
    public Projet retrieveProjet(Long idProjet) {
        return projetRepository.findById(Long.valueOf(idProjet)).get();

    }

    @Override
    public void removeProjet(Long idProjet) {
        projetRepository.deleteById(idProjet);
    }
}