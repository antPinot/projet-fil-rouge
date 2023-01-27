package fr.diginamic.GP3Covoiturage.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.diginamic.GP3Covoiturage.models.Adresse;
import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.models.Covoiturage;



/**
 * @author Fekhreddine
 */
@Repository
public interface CovoiturageRepository extends JpaRepository<Covoiturage, Integer>{
	

	public List<Covoiturage> findByAdresseArrivee(Adresse adresseArrivee);
	
    public List<Covoiturage> findByAdresseDepart(Adresse adresseDepart);
    
    public List<Covoiturage> findByDateDepart(LocalDateTime dateDepart);
    
    public  List<Covoiturage> findByNbPersonnes(Integer nbPersonnes);
    
    public List<Covoiturage> findByPlacesRestantes(Integer placesRestantes);
    
   public List<Covoiturage> findByOrganisateur(Collaborateur organisateur);
    
   //public List<Covoiturage> findByCollaborateurs(List<Collaborateur> collaborateurs); //ici query avec un join
   
   
   /**
    * @method qui selectionne tous les covoiturages
    * par collaborateur
    */
   @Query("SELECT DISTINCT c FROM Covoiturage c JOIN c.collaborateurs c WHERE c =:collaborateur")
	public List<Covoiturage> findByAllCoivoituragesByCollaborateurs(@Param("collaborateur") Collaborateur collaborateur);
	
}
