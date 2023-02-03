package fr.diginamic.GP3Covoiturage.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

import fr.diginamic.GP3Covoiturage.exceptions.FunctionalException;
import fr.diginamic.GP3Covoiturage.models.ReservationVehicule;
import fr.diginamic.GP3Covoiturage.models.VehiculeSociete;
import fr.diginamic.GP3Covoiturage.repositories.ReservationVehiculeRepository;
import fr.diginamic.GP3Covoiturage.repositories.VehiculeSocieteRepository;
import fr.diginamic.GP3Covoiturage.utils.DateUtils;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Transactional
public class VehiculeSocieteService {

	@Autowired
	public VehiculeSocieteRepository vehiculeSocieteRepository;

	@Autowired
	public ReservationVehiculeRepository reservationVehiculeRepository;

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
	 * METHODE A VERIFIER VIA POSTMAN
	 * 
	 * METHODE QUI MARCHE VOIR SI ID IL FAUT LE DEGAGER
	 * 
	 **/
	public List<VehiculeSociete> getVehiculesSocietesDispo(Integer id, String dateDepart, String dateRetour) {

		LocalDateTime time1 = DateUtils.stringToLocalDateTime(dateDepart);
		LocalDateTime time2 = DateUtils.stringToLocalDateTime(dateRetour);

		return  vehiculeSocieteRepository.VehiculesDispo( id, time1, time2);

	}

	/**
	 * Creer un nouveau vehicule de services
	 * 
	 * 
	 * METHODE A VERIFIER VIA POSTMAN
	 * 
	 * @throws FunctionalException
	 * 
	 **/

	public VehiculeSociete createVehicule(VehiculeSociete vehiculeSociete) throws FunctionalException {

		if (vehiculeSociete.getDisponible() == false) {

			throw new FunctionalException("Erreur : Le vehicule n'est pas disponible");
		}
		return vehiculeSocieteRepository.save(vehiculeSociete);
	}
}

/** Modifier un vehicule de service et gerer son cycle de vie **/
