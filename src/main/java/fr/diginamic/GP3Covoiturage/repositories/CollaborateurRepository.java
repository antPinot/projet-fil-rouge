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
	
	public List<Collaborateur> findByMail(String mail);
	
	public List<Collaborateur> findByCovoiturage(Covoiturage annonces);
	
	public List<Collaborateur> findByReservationVehicule(ReservationVehicule reservationsVehicule);
	
	@Query("SELECT c FROM Collaborateur c JOIN c.vehiculePersonnel v WHERE v = :vehiculePersonnel")
	public List<Collaborateur> findCollaborateurlByVehiculePersonnels(@Param("vehiculePersonnel") VehiculePersonnel vehiculePersonnel);
	
	@Query("SELECT c FROM Collaborateur c JOIN c.roles r WHERE r = :role")
	public List<Collaborateur> findCollaborateurlByRoles(@Param("role") Role role);
	
	@Query("SELECT c FROM Collaborateur c JOIN c.covoiturage c WHERE c = :covoiturage")
	public List<Collaborateur> findCollaborateurlByCovoiturages(@Param("covoiturage") Covoiturage covoiturage);

}
