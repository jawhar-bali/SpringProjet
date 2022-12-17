package com.example.spring.services;

import lombok.AllArgsConstructor;
import com.example.spring.entites.Classe;
import com.example.spring.repository.IClasseRepository;
import com.example.spring.repository.IEtudiantRepositroy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClasseService implements IClasse{
    private final IClasseRepository classeRepository;
    @Override
    public List<Classe> retrieveAllClasse() {
        return (List<Classe>) classeRepository.findAll();
    }
    @Override
    public Classe addClasse(Classe cl) {
        return  classeRepository.save(cl);
    }
    @Override
    public Classe updateClasse(Classe cl) {
        return classeRepository.save(cl);
    }
    @Override
    public Classe retrieveClasse(Long idClasse) {
        return classeRepository.findById(Long.valueOf(idClasse)).get();

    }

    @Override
    public void removeClasse(Long idClasse) {
        classeRepository.deleteById(idClasse);
    }
}
