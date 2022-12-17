package com.example.spring.services;
import com.example.spring.entites.Etudiant;
import com.example.spring.entites.Specialite;
import com.example.spring.repository.IContractRepository;
import com.example.spring.repository.IEtudiantRepositroy;
import lombok.AllArgsConstructor;
import com.example.spring.entites.Contrat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Slf4j
@Service
@AllArgsConstructor
public class ContratService implements IContrat {
    private  IContractRepository contractRepository;
    private IEtudiantRepositroy etudiantRepositroy;
    @Override
     public List<Contrat> retrieveAllContrat() {
         return (List<Contrat>) contractRepository.findAll();
     }
    @Override
    public Contrat addContrat(Contrat c) {
        return  contractRepository.save(c);
    }
    @Override
    public Contrat updateContrat(Contrat c) {
        return contractRepository.save(c);
    }
    @Override
    public Contrat retrieveContrat(Long idContrat) {
        return contractRepository.findById(Long.valueOf(idContrat)).get();

    }

    @Override
    public void removeContrat(Long idContrat) {
        contractRepository.deleteById(idContrat);
    }
    @Override
    public Contrat affectContratToEtudiant(Long idContrat, String nomE, String prenomE) {
        Contrat ce= contractRepository.findById(idContrat).orElse(null);
        Etudiant etudiant = etudiantRepositroy.findEtudiantByprenomE(prenomE);
        Set<Contrat> contratsEtudiant = etudiant.getContrat();
        if(contratsEtudiant.size() < 5) ce.setEtudiant(etudiant);
        return contractRepository.save(ce);

    }
   // @Scheduled(cron = "*/15 * * * * *" )
  /*  public void bonjour()
    {
        System.out.println("");
        log.info("Hello");
    }*/

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> listContrat=contractRepository.contratBetween2dates(startDate,endDate);
        System.out.println(listContrat);
        float chiffre=0;
        for( Contrat c:listContrat){
            if(c.getSpecialite().equals(Specialite.IA)){
                chiffre=chiffre+300;
            }
            else if (c.getSpecialite().equals(Specialite.RESEAUX)){
                chiffre=chiffre+350;
            }
            else if(c.getSpecialite().equals(Specialite.CLOUD)){
                chiffre=chiffre+400;
            }
            else if (c.getSpecialite().equals(Specialite.SECURITE)){
                chiffre=chiffre+450;
            }
        }
        return chiffre;
    }
    @Override
    public List<Contrat> contratBetween2dates(Date startDate, Date endDate) {
        return  contractRepository.contratBetween2dates(startDate,endDate);
    }
    @Override
    public Integer nbContratsValides(Date endDate, Date startDate) {
        return contractRepository.countContratByDateDebutContratAfterAndDateFinContratBefore(endDate,startDate);
    }
    //@Scheduled(cron = "*/15 * * * * *" )
   // @Scheduled(fixedRate = 15000)
  /*  public void retrieveAndUpdateStatusContrat(){
        SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
        Calendar c= Calendar.getInstance();
        //adding 12 days to c:Calendar
        c.add(Calendar.DATE,15);
        //convert calendar -> date
        Date alertDate=c.getTime();
        for(Contrat contrats: retrieveAllContrat())
        {
            //System.out.println(formatter.format(contrats.getDateFinContrat()));
            //System.out.println(formatter.format(alertDate));
            if(formatter.format(contrats.getDateFinContrat()).equals(formatter.format(alertDate))) {
                log.info("Alert : ID :" + contrats.getIdContrat() +" "+"date Fin : "+  contrats.getDateFinContrat() +" "+ "Specialite : " + contrats.getSpecialite() + " " + "Etudiant: " + contrats.getEtudiant());
            }
            if (formatter.format(contrats.getDateFinContrat()).equals(formatter.format(Calendar.getInstance().getTime()))) {
                contrats.setArchive(true);
                contractRepository.save(contrats);
                log.info(" Contract Archive : ID :" + contrats.getIdContrat() +"  "+"date Fin :"+contrats.getDateFinContrat() +" "+"date d'aujourd'hui: "+formatter.format(Calendar.getInstance().getTime()));


            }
        }
    }*/

}


