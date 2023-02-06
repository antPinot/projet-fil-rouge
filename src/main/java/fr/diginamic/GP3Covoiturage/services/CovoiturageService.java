package fr.diginamic.GP3Covoiturage.services;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

	/**
	 * @method create()
	 */

	public Covoiturage create(@Valid Covoiturage createCovoiturage) {

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

		return this.covoiturageRepository.save(createCovoiturage);
	}

	/**
	 * @method update()
	 */
	public Covoiturage update(@Valid Covoiturage updateCovoiturage) {
		
		if (updateCovoiturage.getId() == null) {

			throw new RuntimeException("erreur : le covoiturage n'est pas encore créer");
		}
		
		if (updateCovoiturage.getNbPersonnes() != 1) {

			throw new RuntimeException("Erreur : le covoiturage possède déja des participants il ne peut donc pas être modifié");
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
				
		return this.covoiturageRepository.save(updateCovoiturage);
	}

	/**
	 * @method findAll()
	 */
	public List<Covoiturage> findAll() {

		return covoiturageRepository.findAll();
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
