/**
 * 
 */
package fr.diginamic.GP3Covoiturage.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.GP3Covoiturage.models.ReservationVehicule;
import fr.diginamic.GP3Covoiturage.repositories.ReservationVehiculeRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

/**
 * @author antPinot
 *
 */

@Service
@Transactional
public class ReservationVehiculeService {

	@Autowired
	private ReservationVehiculeRepository reservationVehiculeRepository;
	

	/**
	 * @param reservationToCreate
	 * @return
	 */
	public ReservationVehicule create(@Valid ReservationVehicule reservationToCreate) {
		if (reservationToCreate.getDateDepart().isBefore(reservationToCreate.getDateRetour())) {
			return reservationVehiculeRepository.save(reservationToCreate);
		}
		return null; //Exception à générer pour invalidité de date
	}

	/** Read */
	public ReservationVehicule findById(Integer id) {
		return reservationVehiculeRepository.findById(id).orElseThrow(() -> new RuntimeException());
	}

	/** Update */
	public ReservationVehicule update(@Valid ReservationVehicule reservationToUpdate) {
		Optional<ReservationVehicule> reservationVehicule = reservationVehiculeRepository.findById(reservationToUpdate.getId());
		if (reservationVehicule.isPresent() && (reservationToUpdate.getDateDepart().isBefore(reservationToUpdate.getDateRetour()))){
			return reservationVehiculeRepository.save(reservationToUpdate);
		}
		return null; // Exception à générer pour invalidité de date ou reservationVehicule inexistante
	}

	/** Delete */
	public void delete(Integer id) {
		Optional<ReservationVehicule> reservationVehiculeToDelete = reservationVehiculeRepository.findById(id);
		if (reservationVehiculeToDelete.isPresent()) {
			reservationVehiculeRepository.delete(reservationVehiculeToDelete.get());
		} else {
			throw new RuntimeException(); // Exception à générer pour reservationVehicule inexistante
		}
	}

}
