package fr.diginamic.GP3Covoiturage.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.diginamic.GP3Covoiturage.enums.Categorie;
import fr.diginamic.GP3Covoiturage.models.VehiculeSociete;

/**
 * Repository de l'entité VehiculeSociete fournissant des méthodes d'accès à la 
 * base de données 
 * @author antPinot
 *
 */

@Repository
public interface VehiculeSocieteRepository extends JpaRepository<VehiculeSociete, Integer> {
	
	/**
	 * @param immatriculation
	 * @return liste de véhicules de société
	 */
	public List<VehiculeSociete> findByImmatriculation(String immatriculation);
	
	/**
	 * @param marque
	 * @return liste de véhicules de société
	 */
	public List<VehiculeSociete> findByMarque(String marque);
	
	/**
	 * @param modele
	 * @return liste de véhicules de société
	 */
	public List<VehiculeSociete> findByModele(String modele);
	
	/**
	 * @param places
	 * @return liste de véhicules de société
	 */
	public List<VehiculeSociete> findByPlaces(Integer places);
	
	/**
	 * @param disponible
	 * @return liste de véhicules de société
	 */
	public List<VehiculeSociete> findByDisponible(boolean disponible);
	
	/**
	 * @param statut
	 * @return liste de véhicules de société
	 */
	public List<VehiculeSociete> findByStatut(Integer statut);
	
	/**
	 * @param categorie
	 * @return liste de véhicules de société
	 */
	public List<VehiculeSociete> findByCategorie(Categorie categorie);
	
	/**
	 * Méthode de recherche de véhicule de société en fonction du nom du collaborateur ayant effectué la réservation 
	 * @param nom
	 * @return liste de véhicules de société
	 */
	@Query("SELECT v FROM VehiculeSociete v JOIN v.reservationsVehicule r JOIN r.collaborateur c WHERE c.nom = :nom")
	public List<VehiculeSociete> findByCollaborateurNom(@Param("nom")String nom);
