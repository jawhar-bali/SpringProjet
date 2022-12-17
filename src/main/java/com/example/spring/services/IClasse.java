package com.example.spring.services;
import com.example.spring.entites.Classe;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface IClasse {

    List<Classe> retrieveAllClasse();

    Classe addClasse(Classe cl);

    Classe updateClasse (Classe cl);

    Classe retrieveClasse (Long idClasse);

    void removeClasse(Long idClasse);



}
