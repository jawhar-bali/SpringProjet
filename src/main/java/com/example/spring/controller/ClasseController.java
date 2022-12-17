package com.example.spring.controller;


import com.example.spring.entites.Classe;
import com.example.spring.services.IClasse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Classe")
@RestController
@RequiredArgsConstructor
@Component

public class ClasseController {
    private final IClasse classe;

    @GetMapping("/AfficherAllClasse")
    List<Classe> retrieveAllClasse() {

        return  classe.retrieveAllClasse();
    }


    @PostMapping("/AjouterClasse")
    Classe addClasse(@RequestBody Classe cl){
        return  classe.addClasse(cl);

    }



    @PutMapping("/ModifierClasse")
    Classe updateClasse (@RequestBody Classe cl){

        return classe.updateClasse(cl);
    }

    @GetMapping("/AfficherClasse/{idE}")
    Classe retrieveClasse (@PathVariable("idE") Long id){
        return classe.retrieveClasse(id);
    }


    @DeleteMapping("/supprimerClasse/{id}")
    void removeClasse (@PathVariable Long id){
        classe.removeClasse(id);

    }
}


