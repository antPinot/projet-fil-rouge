package fr.diginamic.GP3Covoiturage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.GP3Covoiturage.exceptions.BadRequestException;
import fr.diginamic.GP3Covoiturage.models.VehiculePersonnel;
import fr.diginamic.GP3Covoiturage.repositories.VehiculePersonnelRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class VehiculePersonnelService {
	
	@Autowired
	public VehiculePersonnelRepository vehiculePersonnelRepository;
	
	public VehiculePersonnel create(@Valid VehiculePersonnel vehiculePersonnelToCreate) {
		if(vehiculePersonnelToCreate.getId() != null) {
			throw new RuntimeException("Id doit être null");
		}
		
		if(vehiculePersonnelToCreate.getLimitePlace() > vehiculePersonnelToCreate.getPlaces()) {
			throw new BadRequestException("Veuillez saisir une limite de places inférieure au nombre de places du véhicule");
		}
		
		return vehiculePersonnelRepository.save(vehiculePersonnelToCreate);
	}
	
	public VehiculePersonnel update(@Valid VehiculePersonnel vehiculePersonnelToUpdate) {
		if (vehiculePersonnelToUpdate.getId() == null) {
			throw new RuntimeException("Id n'est pas valide");
		}
		return vehiculePersonnelRepository.save(vehiculePersonnelToUpdate);
	}
	
	public void delete(Integer id) {
		if(id == null) {
			throw new RuntimeException("Id n'est pas valide");
		}
		vehiculePersonnelRepository.deleteById(id);
	}
	
	public VehiculePersonnel findById(Integer id) {
		return vehiculePersonnelRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	public List<VehiculePersonnel> findAll() {
		return vehiculePersonnelRepository.findAll();
	}
	
	public List<VehiculePersonnel> findByCollaborateurId(Integer id){
		return vehiculePersonnelRepository.findByCollaborateurId(id);
	}

}
