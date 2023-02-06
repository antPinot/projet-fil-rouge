package fr.diginamic.GP3Covoiturage.services;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.LocalTime;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.GP3Covoiturage.dto.CovoiturageDto;
import fr.diginamic.GP3Covoiturage.dto.CovoiturageDtoMapper;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.AdresseDtoLight;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.AdresseDtoLightMapper;

import fr.diginamic.GP3Covoiturage.exceptions.BadRequestException;
import fr.diginamic.GP3Covoiturage.exceptions.EntityNotFoundException;
import fr.diginamic.GP3Covoiturage.exceptions.FunctionalException;

import fr.diginamic.GP3Covoiturage.models.Adresse;
import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.models.Covoiturage;
import fr.diginamic.GP3Covoiturage.repositories.CovoiturageRepository;
import fr.diginamic.GP3Covoiturage.utils.CovoiturageUtils;
import fr.diginamic.GP3Covoiturage.utils.DateUtils;
import jakarta.validation.Valid;

/**
 * @author Fekhreddine
 */

@Service
public class CovoiturageService {

	@Autowired
	CovoiturageRepository covoiturageRepository;

	@Autowired
	AdresseService adresseService;

	@Autowired
	CollaborateurService collaborateurService;

	@Autowired
	VehiculePersonnelService vehiculePersonnelService;

	/**
	 * @throws FunctionalException
	 * @method create()
	 */

	public Covoiturage create(@Valid Covoiturage createCovoiturage) throws BadRequestException {

		if (createCovoiturage.getId() != null) {
			throw new RuntimeException("erreur : id est deja present");
		}
		CovoiturageUtils.adresseChecker(createCovoiturage);
		CovoiturageUtils.placesChecker(createCovoiturage);

		return this.covoiturageRepository.save(createCovoiturage);
	}

	/**
	 * @method update()
	 */
	public Covoiturage update(@Valid Covoiturage updateCovoiturage) {
		
		if (updateCovoiturage.getId() == null) {
			throw new RuntimeException("erreur : le covoiturage n'est pas encore créer");
		}
    
		CovoiturageUtils.adresseChecker(updateCovoiturage);
		CovoiturageUtils.updatePlaces(updateCovoiturage);
		
		if (updateCovoiturage.getNbPersonnes() != 1) {

			throw new RuntimeException("Erreur : le covoiturage possède déja des participants il ne peut donc pas être modifié");
		}
				
		return this.covoiturageRepository.save(updateCovoiturage);
	}

	/**
	 * Associe un collaborateur à un covoiturage en tant que participant
	 * 
	 * @param id
	 * @param collaborateurId
	 * @return
	 */
	public Covoiturage reserverCovoiturage(Integer id, Integer collaborateurId) {
		Covoiturage covoiturageToBook = findById(id);

		// Vérification que le demandeur n'est pas le chauffeur
		if (covoiturageToBook.getOrganisateur().getId().equals(collaborateurId)) {
			throw new BadRequestException("Vous êtes déjà le chauffeur de ce covoiturage");
		}

		covoiturageToBook.getCollaborateurs().add(new Collaborateur(collaborateurId));
		covoiturageToBook.setNbPersonnes(covoiturageToBook.getNbPersonnes() + 1);
		covoiturageToBook.setPlacesRestantes(covoiturageToBook.getPlacesRestantes() - 1);
		return covoiturageRepository.save(covoiturageToBook);
	}

	/**
	 * Annule la participation d'un collaborateur à un covoiturage
	 * 
	 * @param id
	 * @param collaborateurId
	 * @return
	 */
	public Covoiturage annulerParticipation(Integer id, Integer collaborateurId) {
		Covoiturage covoiturageToUpdate = findById(id);
		for (Collaborateur collaborateur : covoiturageToUpdate.getCollaborateurs()) {
			if (collaborateur.getId().equals(collaborateurId)) {
				covoiturageToUpdate.getCollaborateurs().remove(collaborateur);
				covoiturageToUpdate.setPlacesRestantes(covoiturageToUpdate.getPlacesRestantes() + 1);
				covoiturageToUpdate.setNbPersonnes(covoiturageToUpdate.getNbPersonnes() - 1);
			}
		}
		return covoiturageRepository.save(covoiturageToUpdate);
	}

	/**
	 * @method findAll()
	 */
	public List<Covoiturage> findAll() {

		return covoiturageRepository.findAll();
	}

	public List<Covoiturage> findEnCoursByCollaborateurs(Integer id, String state) throws BadRequestException {
		switch (state) {
		case "en-cours":
			return covoiturageRepository.findEnCoursByCollaborateur(id);
		case "historique":
			return covoiturageRepository.findHistoriqueByCollaborateur(id);
		default:
			throw new BadRequestException("Requête Invalide");
		}
	}

	public List<Covoiturage> findByCriteres(Integer collaborateurId, String adresseDepart, String adresseArrivee,
			String dateDepart) throws BadRequestException {
		if (adresseDepart.equals("none") && adresseArrivee.equals("none") && dateDepart.equals("none")) {
			throw new BadRequestException("Veuillez saisir au moins un critère de recherche");
		} else if (adresseDepart.equals("none") && adresseArrivee.equals("none")) {
			LocalDate dateDepartTime = DateUtils.stringToLocalDate(dateDepart);
			List<Covoiturage> covoiturages = covoiturageRepository.findBeetweenStartOfDaytAndEndOfDay(
					dateDepartTime.atTime(LocalTime.MIDNIGHT), dateDepartTime.atTime(LocalTime.MAX));

			// Retrait des covoiturages dont le collaborateur est chauffeur ou participant

			CovoiturageUtils.filtrerAffichage(collaborateurId, covoiturages);

			return covoiturages;
			
		} else {
			throw new BadRequestException("Requête Invalide");
		}

	}

	/**
	 * @method findById()
	 */
	public Covoiturage findById(Integer id) {
		return this.covoiturageRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Le covoiturage recherché n'existe pas"));
	}

	/**
	 * @method delete()
	 */
	public void delete(Integer id) {

		if (id == null) {
			throw new RuntimeException("erreur : id covoiturage pas present");
		}
		this.covoiturageRepository.deleteById(id);
	}
	
	public void deleteAfterDate(Integer id, LocalDate dateDepart) {
		
		LocalDate ajd = LocalDate.now();
		if (dateDepart.isEqual(ajd) || dateDepart.isAfter(ajd)) {
			
		}
		this.covoiturageRepository.deleteById(id);
	}
	
	public List<Covoiturage> findCovoitByOrganisateur(Integer id, String statut) throws FunctionalException {
		switch (statut) {
			case "En-cours":
				return covoiturageRepository.findByAllCoivoituragesEnCoursByOrganisateurs(id);
			case "Historique":
				return covoiturageRepository.findByAllCoivoituragesPasseByOrganisateurs(id);
		default:
			throw new FunctionalException("Vous n'avez pas dit le mot magique");
		}
	}
	
	public void annulerCovoit(Integer id, Collaborateur idOrganisateur) {
		Collaborateur organisateur = new Collaborateur();
		for (Covoiturage covoit : organisateur.getAnnonces()) {
			if (organisateur.getId().equals(idOrganisateur)) {
				if (organisateur.getAnnonces().equals(id) && covoit.getDateDepart().isAfter(LocalDateTime.now()) ) {
					covoiturageRepository.delete(organisateur.getAnnonces().get(id));
				}
			}
		}
	}

}
