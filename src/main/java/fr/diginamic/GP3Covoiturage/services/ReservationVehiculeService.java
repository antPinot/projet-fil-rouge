/**
 * 
 */
package fr.diginamic.GP3Covoiturage.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.GP3Covoiturage.exceptions.BadRequestException;
import fr.diginamic.GP3Covoiturage.exceptions.FunctionalException;

import fr.diginamic.GP3Covoiturage.models.ReservationVehicule;
import fr.diginamic.GP3Covoiturage.models.VehiculeSociete;
import fr.diginamic.GP3Covoiturage.repositories.ReservationVehiculeRepository;
import fr.diginamic.GP3Covoiturage.utils.DateUtils;
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

	@Autowired
	private VehiculeSocieteService vehiculeSocieteService;

	/**
	 * @param reservationToCreate
	 * @return
	 */
	public ReservationVehicule create(@Valid ReservationVehicule reservationToCreate) {
		if (reservationToCreate.getDateDepart().isBefore(reservationToCreate.getDateRetour())) {
			return reservationVehiculeRepository.save(reservationToCreate);
		}

		throw new BadRequestException("Votre saisie de date est invalide"); //Exception à générer pour invalidité de date

	}

	/** Read */
	public ReservationVehicule findById(Integer id) {
		return reservationVehiculeRepository.findById(id).orElseThrow(() -> new RuntimeException());
	}

	public List<ReservationVehicule> findAll() {
		return reservationVehiculeRepository.findAll();
	}
	
	public List<ReservationVehicule> findByCollaborateur(Integer id, String state) throws BadRequestException {
		switch (state) {
		case "en-cours":
			return reservationVehiculeRepository.findEnCoursByCollaborateur(id);
		case "historique":
			return reservationVehiculeRepository.findHistoriqueByCollaborateur(id);
		default:
			throw new BadRequestException("Requête Invalide");
		}
	}
	
	public List<ReservationVehicule> findEnCoursByVehiculeSociete(VehiculeSociete vehiculeSociete){
		return reservationVehiculeRepository.findEnCoursByVehiculeSociete(vehiculeSociete);
	}

	/** Update */
	public ReservationVehicule update(@Valid ReservationVehicule reservationToUpdate) {
		Optional<ReservationVehicule> reservationVehicule = reservationVehiculeRepository
				.findById(reservationToUpdate.getId());
		if (reservationVehicule.isPresent()
				&& (reservationToUpdate.getDateDepart().isBefore(reservationToUpdate.getDateRetour()))) {
			return reservationVehiculeRepository.save(reservationToUpdate);
		}
		return null; // Exception à générer pour invalidité de date ou reservationVehicule
						// inexistante
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

	/*************** METHODES METIERS **********************/
	/** Reserver vehicule de service 
	 * @throws FunctionalException **/
	public ReservationVehicule saveReserv(ReservationVehicule reservationVehicule) throws FunctionalException {

		if (reservationVehicule.getDateDepart().isAfter(reservationVehicule.getDateRetour())) {

			 

			 throw new FunctionalException("Erreur : Date de départ est après la date de retour");

		}
		VehiculeSociete vehicule = vehiculeSocieteService.findById(reservationVehicule.getVehiculeSociete().getId());

		if (vehicule.getDisponible() == false) {
			System.out.println("Erreur : Véhicule non disponible");
			return null;
		}

		// listes des reservations en fonctions des dates
		List<ReservationVehicule> existingReservations = reservationVehiculeRepository.BLABLA(vehicule.getId(),
				reservationVehicule.getDateDepart(), reservationVehicule.getDateRetour());

		if (!existingReservations.isEmpty()) {
			System.out.println("Erreur : Véhicule déjà réservé pour cette période");
			return null;
		}
		return reservationVehiculeRepository.save(reservationVehicule);

	}

	/** Modifier la reservation d'un vehicule de service 
	 * @throws FunctionalException **/
	public ReservationVehicule updateReserv(ReservationVehicule reservationVehicule) throws FunctionalException {
		if (reservationVehicule.getDateDepart().isAfter(reservationVehicule.getDateRetour())) {

			throw new FunctionalException("Erreur : Date de départ est après la date de retour");
 

		}
		VehiculeSociete vehicule = vehiculeSocieteService.findById(reservationVehicule.getVehiculeSociete().getId());

		if (vehicule.getDisponible() == false) {
			System.out.println("Erreur : Véhicule non disponible");
			return null;
		}

		// listes des reservations en fonctions des dates
		List<ReservationVehicule> existingReservations = reservationVehiculeRepository.BLABLA(
				vehicule.getId(), reservationVehicule.getDateDepart(), reservationVehicule.getDateRetour());
		
		List<ReservationVehicule> reservationAutreCollaborateur = new ArrayList<>();

		if (!existingReservations.isEmpty()) {
			for (ReservationVehicule existingReservation : existingReservations) {
				if (existingReservation.getCollaborateur().getId() != reservationVehicule.getCollaborateur().getId()) {
					reservationAutreCollaborateur.add(existingReservation);
				}
			}
		}
		
		if (!reservationAutreCollaborateur.isEmpty()) {
			throw new FunctionalException("Votre modification chevauche une autre réservation");
		}

		return reservationVehiculeRepository.save(reservationVehicule);
	}

	
	/***   methode pour rechercher   ****/
	public List<ReservationVehicule> searchReserv(Integer Id, String dateDepart, String dateRetour) {

		LocalDateTime time1 = DateUtils.stringToLocalDateTime(dateDepart);
		LocalDateTime time2 = DateUtils.stringToLocalDateTime(dateRetour);

		return reservationVehiculeRepository.BLABLA(Id, time1, time2);

	}
	/**
	 * Supprimer la reservation d'un vehicule de service
	 * 
	 * 
	 * on appele juste la methode delete
	 * 
	 **/

}
