package fr.diginamic.GP3Covoiturage.services;

import java.util.HashMap;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.GP3Covoiturage.exceptions.BadRequestException;
import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.repositories.CollaborateurRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Transactional
public class CollaborateurService {

	@Autowired
	public CollaborateurRepository collaborateurRepository;

	public Collaborateur create(@Valid Collaborateur collaborateurToCreate) {
		if (collaborateurToCreate.getId() != null) {
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
		if (id == null) {
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

	public Collaborateur findOneByToken(String token) {
		return collaborateurRepository.findByToken(token);
	}

	public Map<String, Object> login(String login, String password) {
		Map<String, Object> tokenJson = new HashMap<>();
		String token = "";
		List<Collaborateur> existingCollaborateur = collaborateurRepository.findByLoginAndPassword(login, password);
		if (existingCollaborateur.size() > 0) {
			token = UUID.randomUUID().toString();
			existingCollaborateur.get(0).setToken(token);
			collaborateurRepository.save(existingCollaborateur.get(0));
			tokenJson.put("access_token", token);
			return tokenJson;
		}
		throw new BadRequestException("Unknown credentials");
	}

	public void logout(String token) {
		Collaborateur existingCollaborateur = collaborateurRepository.findByToken(token);
		if (existingCollaborateur != null) {
			existingCollaborateur.setToken(null);
			collaborateurRepository.save(existingCollaborateur);
		}
	}

	/**
	 * ICI LES METHODES SIGNIN LOGIN ET LOGOUT (FEKHREDDINE)
	 * 
	 * public String login(String login, String password) {
	 * 
	 * String token = ""; Collaborateur collaborateur =
	 * collaborateurRepository.findByLoginAndPassword(login, password);
	 * 
	 * if(collaborateur!= null) {
	 * 
	 * // Validate the password token = UUID.randomUUID().toString();
	 * collaborateur.setToken(token); collaborateurRepository.save(collaborateur);
	 * 
	 * return token; }
	 * 
	 * throw new BadRequestException("erreur");
	 * 
	 * 
	 * 
	 * }
	 * 
	 * public void logout(String login, String password) { // TODO Auto-generated
	 * method stub
	 * 
	 * Collaborateur collaborateur =
	 * collaborateurRepository.findByLoginAndPassword(login, password); if
	 * (collaborateur!= null) { // Remove the token collaborateur.setToken(null);
	 * collaborateurRepository.save(collaborateur); }
	 * 
	 * }
	 * 
	 * 
	 **/

	public boolean existsByEmail(String email) {
		try {
			return CollaborateurRepository.existsByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erreur lors de la vérification de l'existence d'un collaborateur par email");
		}
	}
}
