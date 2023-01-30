package fr.diginamic.GP3Covoiturage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.repositories.CollaborateurRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class CollaborateurService {
	
	@Autowired
	public CollaborateurRepository collaborateurRepository;
	
	public Collaborateur create(@Valid Collaborateur collaborateurToCreate) {
		if(collaborateurToCreate.getId() != null) {
			throw new RuntimeException("Id doit être null");
		}
		return collaborateurRepository.save(collaborateurToCreate);
	}
	
	public Collaborateur update(@Valid Collaborateur collaborateurToUpdate) {
		if (collaborateurToUpdate.getId() == null) {
			throw new RuntimeException("Id n'est pas valide");
		}
		return collaborateurRepository.save(collaborateurToUpdate);
	}
	
	public void delete(Integer id) {
		if(id == null) {
			throw new RuntimeException("Id n'est pas valide");
		}
		collaborateurRepository.deleteById(id);
	}
	
	public Collaborateur findById(Integer id) {
		return collaborateurRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	public List<Collaborateur> findAll() {
		return collaborateurRepository.findAll();
	}

}
