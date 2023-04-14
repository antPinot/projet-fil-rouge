package fr.diginamic.GP3Covoiturage.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.models.Covoiturage;
import fr.diginamic.GP3Covoiturage.models.ReservationVehicule;
import fr.diginamic.GP3Covoiturage.models.Role;
import fr.diginamic.GP3Covoiturage.models.VehiculePersonnel;

@Repository
public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {
	
	public List<Collaborateur> findByMatricule(Integer matricule);
	
	public List<Collaborateur> findByNom(String nom);
	
	public List<Collaborateur> findByNomAndPrenom(String nom, String prenom);
	
	public List<Collaborateur> findByDateNaissance(LocalDate dateNaissance);
	
	public List<Collaborateur> findByTelephone(Integer telephone);
	
	public Collaborateur findByMail(String mail);
	
	public List<Collaborateur> findByAnnonces(Covoiturage annonces);
	
	public List<Collaborateur> findByReservationsVehicule(ReservationVehicule reservationsVehicule);
	
	/* Méthode ANTHONY à effacer à posteriori */
	public List<Collaborateur> findByLoginAndPassword(String login, String password);
	
	public Collaborateur findByToken(String token);
	
	public Collaborateur findByPasswordToken(String passwordToken);
	
	/* Méthode FEKHREDDINE à utiliser à posteriori 
	public Collaborateur findByLoginAndPassword(String login, String password);
	*/

	
	@Query("SELECT c FROM Collaborateur c JOIN c.vehiculesPersonnel v WHERE v = :vehiculePersonnel")
	public List<Collaborateur> findCollaborateurlByVehiculePersonnels(@Param("vehiculePersonnel") VehiculePersonnel vehiculePersonnel);
	
	@Query("SELECT c FROM Collaborateur c JOIN c.roles r WHERE r = :role")
	public List<Collaborateur> findCollaborateurlByRoles(@Param("role") Role role);
	
	@Query("SELECT c FROM Collaborateur c JOIN c.covoiturages cov WHERE cov = :covoiturage")
	public List<Collaborateur> findCollaborateurlByCovoiturages(@Param("covoiturage") Covoiturage covoiturage);
     
	
	
	/** METHODE qui renvoi un boolean **/
	 static boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
