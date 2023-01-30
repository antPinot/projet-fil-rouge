package fr.diginamic.GP3Covoiturage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.GP3Covoiturage.dto.CollaborateurDto;
import fr.diginamic.GP3Covoiturage.dto.CollaborateurDtoMapper;
import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.services.CollaborateurService;

@RestController
@RequestMapping("")
public class CollaborateurController {
	
	@Autowired
	public CollaborateurService collaborateurService;
	
	@PostMapping
	public CollaborateurDto create(@RequestBody CollaborateurDto collaborateurToCreate) {
		Collaborateur modelCollab = CollaborateurDtoMapper.toModel(collaborateurToCreate);
		collaborateurService.create(modelCollab);
		return collaborateurToCreate;
	}
	
	@PutMapping
	public CollaborateurDto update(@RequestBody CollaborateurDto collaborateurToUpdate) {
		Collaborateur modelCollab = CollaborateurDtoMapper.toModel(collaborateurToUpdate);
		collaborateurService.update(modelCollab);
		return collaborateurToUpdate;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		collaborateurService.delete(id);
	}
	
	@GetMapping("/{id}")
	public CollaborateurDto findById(@PathVariable("id") Integer id) {
		return CollaborateurDtoMapper.toDto(collaborateurService.findById(id));
	}
	
	@GetMapping()
	public List<Collaborateur> findAllCollaborateur() {
		return collaborateurService.findAll();
	}
	
}
