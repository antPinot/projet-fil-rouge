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
import fr.diginamic.GP3Covoiturage.exceptions.FunctionalException;
import fr.diginamic.GP3Covoiturage.models.Adresse;
import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.models.Covoiturage;
import fr.diginamic.GP3Covoiturage.repositories.CovoiturageRepository;
import fr.diginamic.GP3Covoiturage.utils.DateUtils;
import jakarta.persistence.EntityNotFoundException;
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

	public Covoiturage create(@Valid Covoiturage createCovoiturage) throws FunctionalException {

		if (createCovoiturage.getId() != null) {
			throw new RuntimeException("erreur : id est deja present");
		}

		// methode pour AdresseArrivée
		Adresse adresseArrivee = createCovoiturage.getAdresseArrivee();
		List<Adresse> query1 = adresseService.findExistingAdresse(adresseArrivee.getNumero(),
				adresseArrivee.getComplementNumero(), adresseArrivee.getVoie(), adresseArrivee.getCodePostal(),
				adresseArrivee.getDepartement(), adresseArrivee.getPays(), adresseArrivee.getVille());

		if (query1.isEmpty()) {
			adresseService.create(adresseArrivee);
			createCovoiturage.setAdresseArrivee(adresseArrivee);
		} else {

			createCovoiturage.setAdresseArrivee(query1.get(0));
		}

		// Attention à l'ordre des paramètres de la méthode findExistingAdresse
		Adresse adresseDepart = createCovoiturage.getAdresseDepart();
		List<Adresse> query = adresseService.findExistingAdresse(adresseDepart.getNumero(),
				adresseDepart.getComplementNumero(), adresseDepart.getVoie(), adresseDepart.getCodePostal(),
				adresseDepart.getDepartement(), adresseDepart.getPays(), adresseDepart.getVille());

		if (query.isEmpty()) {
			adresseService.create(adresseDepart);
			createCovoiturage.setAdresseDepart(adresseDepart);
		} else {
			createCovoiturage.setAdresseDepart(query.get(0));
		}

		// Contrôle coherénce nb personnes - places restantes
		Integer placesVehicule = createCovoiturage.getVehiculePersonnel().getLimitePlace();
		Integer placesRestantes = createCovoiturage.getPlacesRestantes();
		Integer nbPersonnes = createCovoiturage.getNbPersonnes();

		if (placesRestantes > placesVehicule) {
			throw new FunctionalException(
					"Veuillez définir un nombre de places inférieur ou égal à la capacité du véhicule");
		}

		createCovoiturage
				.setPlacesRestantes(createCovoiturage.getPlacesRestantes() - createCovoiturage.getNbPersonnes());

		return this.covoiturageRepository.save(createCovoiturage);
	}

	/**
	 * @method update()
	 */
	public Covoiturage update(@Valid Covoiturage updateCovoiturage) {

		if (updateCovoiturage.getId() == null) {

			throw new RuntimeException("erreur : le covoiturage n'est pas encore créer");
		}

		// methode pour AdresseArrivée
		Adresse adresseArrivee = updateCovoiturage.getAdresseArrivee();
		List<Adresse> query1 = adresseService.findExistingAdresse(adresseArrivee.getNumero(),
				adresseArrivee.getComplementNumero(), adresseArrivee.getVoie(), adresseArrivee.getCodePostal(),
				adresseArrivee.getDepartement(), adresseArrivee.getPays(), adresseArrivee.getVille());

		if (query1.isEmpty()) {
			adresseService.create(adresseArrivee);
			updateCovoiturage.setAdresseArrivee(adresseArrivee);
		} else {

			updateCovoiturage.setAdresseArrivee(query1.get(0));
		}

		// Attention à l'ordre des paramètres de la méthode findExistingAdresse
		Adresse adresseDepart = updateCovoiturage.getAdresseDepart();
		List<Adresse> query = adresseService.findExistingAdresse(adresseDepart.getNumero(),
				adresseDepart.getComplementNumero(), adresseDepart.getVoie(), adresseDepart.getCodePostal(),
				adresseDepart.getDepartement(), adresseDepart.getPays(), adresseDepart.getVille());

		if (query.isEmpty()) {
			adresseService.create(adresseDepart);
			updateCovoiturage.setAdresseDepart(adresseDepart);
		} else {
			updateCovoiturage.setAdresseDepart(query.get(0));
		}

		// Changement du nb de places

		if (updateCovoiturage.getCollaborateurs() != null) {
			int placesRestantes = updateCovoiturage.getPlacesRestantes()
					- (updateCovoiturage.getCollaborateurs().size());
			updateCovoiturage.setPlacesRestantes(placesRestantes);
		}

		return this.covoiturageRepository.save(updateCovoiturage);
	}
	
	public Covoiturage reserverCovoiturage(Integer id, Integer collaborateurId) {
		Covoiturage covoiturageToBook = findById(id);
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
				covoiturageToUpdate.setNbPersonnes(covoiturageToUpdate.getPlacesRestantes() - 1);
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

	public List<Covoiturage> findEnCoursByCollaborateurs(Integer id, String state) throws FunctionalException {
		switch (state) {
		case "en-cours":
			return covoiturageRepository.findEnCoursByCollaborateur(id);
		case "historique":
			return covoiturageRepository.findHistoriqueByCollaborateur(id);
		default:
			throw new FunctionalException("Requête Invalide");
		}
	}

	public List<Covoiturage> findByCriteres(String adresseDepart, String adresseArrivee, String dateDepart)
			throws FunctionalException {
		if (adresseDepart.equals("none") && adresseArrivee.equals("none")) {
			LocalDate dateDepartTime = DateUtils.stringToLocalDate(dateDepart);
			return covoiturageRepository.findBeetweenStartOfDaytAndEndOfDay(dateDepartTime.atTime(LocalTime.MIDNIGHT),
					dateDepartTime.atTime(LocalTime.MAX));
		} else if (adresseDepart.equals("none") && adresseArrivee.equals("none") && dateDepart.equals("none")) {
			throw new FunctionalException("Veuillez saisir au moins un critère de recherche");
		} else {
			throw new FunctionalException("Requête Invalide");
		}
	}

	/**
	 * @method findById()
	 */
	public Covoiturage findById(Integer id) {
		return this.covoiturageRepository.findById(id).orElseThrow(EntityNotFoundException::new);
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

}
