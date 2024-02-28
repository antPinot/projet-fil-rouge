package fr.diginamic.GP3Covoiturage.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.diginamic.GP3Covoiturage.enums.Categorie;
import fr.diginamic.GP3Covoiturage.models.Covoiturage;
import fr.diginamic.GP3Covoiturage.models.ReservationVehicule;
import fr.diginamic.GP3Covoiturage.models.VehiculeSociete;

/**
 * Repository de l'entité VehiculeSociete fournissant des méthodes d'accès à la
 * base de données
 * 
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
	 * Méthode de recherche de véhicule de société en fonction du nom du
	 * collaborateur ayant effectué la réservation
	 * 
	 * @param nom
	 * @return liste de véhicules de société
	 */
	@Query("SELECT v FROM VehiculeSociete v JOIN v.reservationsVehicule r JOIN r.collaborateur c WHERE c.nom = :nom")
	public List<VehiculeSociete> findByCollaborateurNom(@Param("nom") String nom);

	/**
	 *  
	 * 
	 * Query qui va afficher tout les vehicules qui ne sont
	 * 
	 * pas dispos entre deux dates precises
	 * 
	 * @param id
	 * 
	 */
//	@Query("SELECT v FROM VehiculeSociete v WHERE NOT EXISTS (SELECT r FROM ReservationVehicule r WHERE((r.dateDepart BETWEEN :dateDepart AND :dateRetour) OR (r.dateRetour BETWEEN :dateDepart AND :dateRetour)))")
	@Query("SELECT v FROM VehiculeSociete v JOIN v.reservationsVehicule r WHERE((r.dateDepart BETWEEN :dateDepart AND :dateRetour) OR (r.dateRetour BETWEEN :dateDepart AND :dateRetour)) ")
	public List<VehiculeSociete> vehiculesReservesBetweenDateDepartAndDateRetour(@Param("dateDepart") LocalDateTime dateDepart, @Param("dateRetour") LocalDateTime dateRetour);
	
}
