/**
 * 
 */
package fr.diginamic.GP3Covoiturage.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.models.ReservationVehicule;
import fr.diginamic.GP3Covoiturage.models.VehiculeSociete;

/**
 * @author antPinot
 *
 */

@Repository
public interface ReservationVehiculeRepository extends JpaRepository<ReservationVehicule, Integer> {
	
	public List<ReservationVehicule> findByDateDepart(LocalDateTime dateDepart);
	
	public List<ReservationVehicule> findByDateRetour(LocalDateTime dateRetour);
	
	@Query("SELECT r FROM ReservationVehicule r WHERE dateDepart BETWEEN :dateDepartAnterieure AND :dateDepartPosterieure")
	public List<ReservationVehicule> findBetweenDatesDepart(@Param("dateDepartAnterieure")LocalDateTime dateDepartAnterieure, @Param("dateDepartPosterieure")LocalDateTime dateDepartPosterieure);
	
	public List<ReservationVehicule> findByCollaborateur(Collaborateur collaborateur);
	
	public List<ReservationVehicule> findByVehiculeSociete(VehiculeSociete vehiculeSociete);
	

}
