package fr.diginamic.GP3Covoiturage.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.GP3Covoiturage.dto.dtoEdit.CollaborateurDtoEdit;
import fr.diginamic.GP3Covoiturage.dto.dtoEdit.CollaborateurDtoEditMapper;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.CollaborateurDtoLight;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.CollaborateurDtoLightMapper;
import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.services.CollaborateurService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/collaborateur")
public class CollaborateurController {

	@Autowired
	public CollaborateurService collaborateurService;

	@PostMapping
	public CollaborateurDtoEdit create(@RequestBody @Valid CollaborateurDtoEdit collaborateurToCreate) {
		Collaborateur modelCollab = CollaborateurDtoEditMapper.toModel(collaborateurToCreate);
		collaborateurService.create(modelCollab);
		return collaborateurToCreate;
	}

	@PutMapping
	public CollaborateurDtoEdit update(@RequestBody CollaborateurDtoEdit collaborateurToUpdate) {
		Collaborateur modelCollab = CollaborateurDtoEditMapper.toModel(collaborateurToUpdate);
		collaborateurService.update(modelCollab);
		return collaborateurToUpdate;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		collaborateurService.delete(id);
	}

	@GetMapping("/{id}")
	public CollaborateurDtoLight findById(@PathVariable("id") Integer id) {
		Collaborateur collaborateur = collaborateurService.findById(id);

		if (collaborateur == null) {

			throw new RuntimeException("probleme : id collaborateur existe pas");
		}

		CollaborateurDtoLight collaborateurDtoLight = CollaborateurDtoLightMapper.toDto(collaborateur);

		return collaborateurDtoLight;

	}
	
	@PostMapping("/token")
	public CollaborateurDtoLight findByToken(@RequestBody String token) {
		System.out.println(token);
		Collaborateur model = collaborateurService.findOneByToken(token);
		CollaborateurDtoLight dto = CollaborateurDtoLightMapper.toDto(model);
		return dto;
	}

	@GetMapping()
	public List<CollaborateurDtoLight> findAllCollaborateur() {
		List<Collaborateur> collaborateurs =  collaborateurService.findAll();
		List<CollaborateurDtoLight> collaborateurDtoLights = new ArrayList<>();
		
		for(Collaborateur c : collaborateurs) {
			
			collaborateurDtoLights.add(CollaborateurDtoLightMapper.toDto(c));
			
		}
		return collaborateurDtoLights;
	}
	
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody Map<String, String> credentials) {
		Map<String, Object> token = collaborateurService.login(credentials.get("login"), credentials.get("password"));
		return token;
	}
	
	@PostMapping("/logout")
	public void logout(@RequestBody Map<String, String> token) {
		collaborateurService.logout(token.get("access_token"));
	}

}
