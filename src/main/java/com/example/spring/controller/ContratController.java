package com.example.spring.controller;

import com.example.spring.entites.Contrat;
import com.example.spring.entites.Etudiant;
import com.example.spring.services.IContrat;
import com.example.spring.services.IEtudiant;
import lombok.RequiredArgsConstructor;
import org.omg.CORBA.UShortSeqHelper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Contrat")
@RestController
@RequiredArgsConstructor
@Component
public class ContratController {
    private final IContrat contrat;

    @GetMapping("/AfficherAllContrat")
    List<Contrat> retrieveAllContrat() {

        return contrat.retrieveAllContrat();
    }


    @PostMapping("/AjouterContrat")
    Contrat addContrat(@RequestBody Contrat c) {
        return contrat.addContrat(c);

    }


    @PutMapping("/ModifierContrat")
    Contrat updateContrat(@RequestBody Contrat c) {

        return contrat.updateContrat(c);
    }

    @GetMapping("/AfficherContrat/{idE}")
    Contrat retrieveContrat(@PathVariable("idE") Long id) {
        return contrat.retrieveContrat(id);
    }


    @DeleteMapping("/supprimerContrat/{id}")
    void removeContrat(@PathVariable Long id) {
        contrat.removeContrat(id);

    }

    @PostMapping("/affectContratToEtudiant/{idContrat}/{nomE}/{prenomE}")
    public Contrat affectContratToEtudiant(@PathVariable Long idContrat, @PathVariable String nomE, @PathVariable String prenomE) {
        return this.contrat.affectContratToEtudiant(idContrat, nomE, prenomE);

    }
    @GetMapping("/getChiffreAffaireEntreDeuxDate/{start}/{end}")
    float getChiffreAffaireEntreDeuxDate(@PathVariable("start")@DateTimeFormat(pattern = "yyyy-MM-dd")  Date start,@PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end){
        return contrat.getChiffreAffaireEntreDeuxDate(start,end);
    }
    @GetMapping("/contratBetween2dates/{start}/{end}")
    List<Contrat> contratBetween2dates(@PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date start, @PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end){
        return contrat.contratBetween2dates(start,end);
    }
    @GetMapping("/nbrContratsValides/{end}/{start}")
    Integer nbContratsValides(@PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end , @PathVariable("start")@DateTimeFormat(pattern = "yyyy-MM-dd")  Date start) {
        return contrat.nbContratsValides(end,start) ;
    }
}
