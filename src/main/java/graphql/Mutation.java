package graphql;

import entite.Logement;
import entite.RendezVous;
import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class Mutation implements GraphQLRootResolver {
    private RendezVousRepository rendezVousRepository;
    private LogementRepository logementRepository;
    public Mutation(RendezVousRepository rendezVousRepository, LogementRepository logementRepository) {
        this.rendezVousRepository = rendezVousRepository;
        this.logementRepository = logementRepository;
    }
    //Question 2
    public RendezVous createRendezVous(int id,String date,String heure,int refLog,String num){
        return this.rendezVousRepository.addRendezVous(new RendezVous(id,date,heure, logementRepository.getLogementsByReference(refLog),num));
    }
    //Question 3
    public boolean updateRendezVous(int id,String date,String heure,String numTel){
        return this.rendezVousRepository.updateRendezVous(new RendezVous(id,date,heure,numTel));
    }
    //Question 6
    public boolean deleteRendezVous(int id){
        return this.rendezVousRepository.deleteRendezVous(id);
    }
    //Question 7
    public Logement createLogement(int ref,String adresse){
        return this.logementRepository.saveLogement(new Logement(ref,adresse));
    }

}
