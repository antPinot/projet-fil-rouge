package fr.diginamic.GP3Covoiturage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.GP3Covoiturage.models.Covoiturage;
import fr.diginamic.GP3Covoiturage.models.ReservationVehicule;
import fr.diginamic.GP3Covoiturage.models.VehiculeSociete;
import fr.diginamic.GP3Covoiturage.repositories.VehiculeSocieteRepository;
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
		if(vehiculeSocieteToCreate.getId() != null) {
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
		}
		
		return vehiculeSocieteRepository.save(vehiculeSocieteToUpdate);
	}
	
	public void delete(Integer id) {
		if(id == null) {
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

}
