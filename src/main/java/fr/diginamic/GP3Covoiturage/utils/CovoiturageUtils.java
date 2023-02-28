/**
 * 
 */
package fr.diginamic.GP3Covoiturage.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.diginamic.GP3Covoiturage.exceptions.BadRequestException;
import fr.diginamic.GP3Covoiturage.models.Adresse;
import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.models.Covoiturage;
import fr.diginamic.GP3Covoiturage.services.AdresseService;

/**
 * @author antPinot
 *
 */
@Component
public class CovoiturageUtils {

	private static AdresseService adresseService;

	@Autowired
	public CovoiturageUtils(AdresseService adresseService) {
		CovoiturageUtils.adresseService = adresseService;
	}

	public static void adresseChecker(Covoiturage covoiturage) {
		Adresse adresseDepart = covoiturage.getAdresseDepart();
		Adresse adresseArrivee = covoiturage.getAdresseArrivee();
		List<Adresse> queryDepart = adresseService.findExistingAdresse(adresseDepart.getNumero(),
				adresseDepart.getComplementNumero(), adresseDepart.getVoie(), adresseDepart.getCodePostal(),
				adresseDepart.getDepartement(), adresseDepart.getPays(), adresseDepart.getVille());

		if (queryDepart.isEmpty()) {
			adresseService.create(adresseDepart);
			covoiturage.setAdresseDepart(adresseDepart);
		} else {
			covoiturage.setAdresseDepart(queryDepart.get(0));
		}

		List<Adresse> queryArrivee = adresseService.findExistingAdresse(adresseArrivee.getNumero(),
				adresseArrivee.getComplementNumero(), adresseArrivee.getVoie(), adresseArrivee.getCodePostal(),
				adresseArrivee.getDepartement(), adresseArrivee.getPays(), adresseArrivee.getVille());

		if (queryArrivee.isEmpty()) {
			adresseService.create(adresseArrivee);
			covoiturage.setAdresseArrivee(adresseArrivee);
		} else {
			covoiturage.setAdresseArrivee(queryArrivee.get(0));
		}

	}

	public static void placesChecker(Covoiturage covoiturage) {
		Integer placesRestantes = covoiturage.getPlacesRestantes();
		Integer nbPersonnes = covoiturage.getNbPersonnes();

		if (nbPersonnes > placesRestantes) {
			throw new BadRequestException(
					"Veuillez définir un nombre de personnes inférieur ou égal à la capacité du véhicule");
		}

		covoiturage.setPlacesRestantes(covoiturage.getPlacesRestantes() - covoiturage.getNbPersonnes());
	}

	public static void updatePlaces(Covoiturage covoiturage) {

		if (covoiturage.getCollaborateurs() != null) {
			int placesRestantes = covoiturage.getPlacesRestantes() - (covoiturage.getCollaborateurs().size());
			covoiturage.setPlacesRestantes(placesRestantes);
		}
	}
	
	// Remarque de Jordi ==> Problème si on utilise le Pageable, voir si filtrage possible directement depuis le Query du Repository
	public static void filtrerAffichage(Integer collaborateurId, List<Covoiturage> covoiturages) {
		List<Covoiturage> covoituragesToRemove = new ArrayList<>();
		for (Covoiturage covoiturage : covoiturages) {
			if (covoiturage.getOrganisateur().getId().equals(collaborateurId) || covoiturage.getPlacesRestantes() == 0) {
				covoituragesToRemove.add(covoiturage);
			} else {
				for (Collaborateur collaborateur : covoiturage.getCollaborateurs()) {
					if (collaborateur.getId().equals(collaborateurId)) {
						covoituragesToRemove.add(covoiturage);
					}
				}
			}
		}
		covoiturages.removeAll(covoituragesToRemove);
	}

}
