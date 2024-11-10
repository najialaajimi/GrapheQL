package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class Query implements GraphQLRootResolver {
    private RendezVousRepository rendezVousRepository;
    private LogementRepository logementRepository;

    public Query (RendezVousRepository repoR, LogementRepository repoL) {
        this.rendezVousRepository= repoR;
        this.logementRepository= repoL;
    }
    //Question 1
    public List<RendezVous> getallrendezVous(){
        return this.rendezVousRepository.getListeRendezVous();
    }

    //Question 4
    public List<RendezVous> getallrendezvousbyLogementRef(int refLog){
        return rendezVousRepository.getListeRendezVousByLogementRef(refLog);
    }
    //Question 5
    public Logement getrendezVousById(int id){
        return rendezVousRepository.getLogementByRDV(id);
    }
    //Question 8
    public List<Logement> getAllLogements(){
        return logementRepository.getAllLogements();
    }
    //Question 9
    public Logement getLogementById(int id){
        return logementRepository.getLogementsByReference(id);
    }
    //Question 10
    public List<Logement> getAllLogementsByType(Logement.Type type){
        return logementRepository.getLogementsByType(type);
    }
}
