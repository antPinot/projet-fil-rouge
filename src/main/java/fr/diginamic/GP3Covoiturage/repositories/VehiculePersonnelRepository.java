package fr.diginamic.GP3Covoiturage.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.models.VehiculePersonnel;

@Repository
public interface VehiculePersonnelRepository extends JpaRepository<VehiculePersonnel, Integer> {
	
	public List<VehiculePersonnel> findByImmatriculation(String immatriculation);
	
	public List<VehiculePersonnel> findByMarque(String marque);
	
	public List<VehiculePersonnel> findByModele(String modele);
	
	public List<VehiculePersonnel> findByPlaces(Integer places);
	
	public List<VehiculePersonnel> findByLimitePlace(Integer limitePlace);
	
	@Query("SELECT v FROM VehiculePersonnel v JOIN v.collaborateurs c WHERE c.id = :collaborateurId")
	public List<VehiculePersonnel> findByCollaborateurId(@Param("collaborateurId") Integer collaborateurId);

	@Query("SELECT v FROM VehiculePersonnel v JOIN v.covoiturages c JOIN c.collaborateurs col WHERE col.nom = :nom")
	public List<VehiculePersonnel> findByNomCollaborateur(@Param("nom")String nom);
	
	@Query("SELECT v FROM VehiculePersonnel v JOIN v.collaborateurs c WHERE c = :collaborateur")
	public List<VehiculePersonnel> findVehiculePersonnelByCollaborateurs(@Param("collaborateur") Collaborateur collaborateur);
}
