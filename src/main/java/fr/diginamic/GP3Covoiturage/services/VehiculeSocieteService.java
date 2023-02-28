package fr.diginamic.GP3Covoiturage.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.GP3Covoiturage.exceptions.FunctionalException;

import fr.diginamic.GP3Covoiturage.models.ReservationVehicule;
import fr.diginamic.GP3Covoiturage.models.VehiculeSociete;
import fr.diginamic.GP3Covoiturage.repositories.VehiculeSocieteRepository;
import fr.diginamic.GP3Covoiturage.utils.DateUtils;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Transactional
public class VehiculeSocieteService {

	@Autowired
	private VehiculeSocieteRepository vehiculeSocieteRepository;
	
	@Autowired
	private ReservationVehiculeService reservationVehiculeService;
	

	public VehiculeSociete create(@Valid VehiculeSociete vehiculeSocieteToCreate) {
		if (vehiculeSocieteToCreate.getId() != null) {
			throw new RuntimeException("Id doit être null");
		}
		return vehiculeSocieteRepository.save(vehiculeSocieteToCreate);
	}

	public VehiculeSociete update(@Valid VehiculeSociete vehiculeSocieteToUpdate) {
		if (vehiculeSocieteToUpdate.getId() == null) {
			throw new RuntimeException("Id n'est pas valide");
		}
		
		//Vehicule n'est pas en service
		if (vehiculeSocieteToUpdate.getStatut() != 1) {
			List<ReservationVehicule> reservations = reservationVehiculeService.findEnCoursByVehiculeSociete(vehiculeSocieteToUpdate);
			reservations.forEach(r -> reservationVehiculeService.delete(r.getId()));
			// Méthode d'envoi de mail à réaliser
		}
		
		return vehiculeSocieteRepository.save(vehiculeSocieteToUpdate);
	}

	public void delete(Integer id) {
		if (id == null) {
			throw new RuntimeException("Id n'est pas valide");
		}
		vehiculeSocieteRepository.deleteById(id);
	}

	public VehiculeSociete findById(Integer id) {
		return vehiculeSocieteRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	public List<VehiculeSociete> findAll() {
		return vehiculeSocieteRepository.findAll();
	}

	/**
	 * Visualiser les vehicules de services
	 * 
	 * 
	 * 
	 * 
	 * METHODE QUI MARCHE VOIR SI ID IL FAUT LE DEGAGER
	 * 
	 **/
	public List<VehiculeSociete> getVehiculesSocietesDispo(String dateDepart, String dateRetour) {

		LocalDateTime time1 = DateUtils.stringToLocalDateTime(dateDepart);
		LocalDateTime time2 = DateUtils.stringToLocalDateTime(dateRetour);

		return vehiculeSocieteRepository.vehiculesDispo(time1, time2);

	}

	/**
	 * Creer un nouveau vehicule de services
	 * 
	 * @author Fekhreddine METHODE FONCTIONNEL VIA POSTMAN
	 * 
	 * @throws FunctionalException
	 * 
	 **/

	public VehiculeSociete createVehicule(VehiculeSociete vehiculeSociete) throws FunctionalException {

		if (!vehiculeSociete.getDisponible()) {

			throw new FunctionalException("Erreur : Le vehicule n'est pas disponible");
		}

		int statut = vehiculeSociete.getStatut();

		if (statut != -1 && statut != 0 && statut != 1) {
			throw new FunctionalException("Erreur : Le statut doit être soit -1, 0 ou 1");
		}
		return vehiculeSocieteRepository.save(vehiculeSociete);
	}



	/**
	 * @author Fekhreddine
	 * 
	 * @throws FunctionalException
	 * 
	 *    Modifier un vehicule de service et gerer son
	 *    cycle de vie
	 **/

	public VehiculeSociete updateVehicule(VehiculeSociete vehiculeSociete) throws FunctionalException {

		VehiculeSociete existingVehicule = vehiculeSocieteRepository.findById(vehiculeSociete.getId())
				.orElseThrow(() -> new FunctionalException("Erreur : Le véhicule n'existe pas"));

		if (!existingVehicule.getDisponible()) {
			throw new FunctionalException("Erreur : Le véhicule n'est pas disponible");
		}

		int statut = vehiculeSociete.getStatut();
		if (statut != -1 && statut != 0 && statut != 1) {
			throw new FunctionalException("Erreur : Le statut doit être soit -1, 0 ou 1");
		}

		existingVehicule.setDisponible(vehiculeSociete.getDisponible());
		existingVehicule.setStatut(vehiculeSociete.getStatut());

		return vehiculeSocieteRepository.save(vehiculeSociete);
	}

}
