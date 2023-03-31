package fr.diginamic.GP3Covoiturage.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.LocalTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

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

	/** covoiturageRepository : Accès aux entités Covoiturage en BDD */
	@Autowired
	CovoiturageRepository covoiturageRepository;

	/** adresseService : Accès aux méthodes de service de la classe Adresse */
	@Autowired
	AdresseService adresseService;

	/**
	 * collaborateurService : Accès aux méthodes de service de la classe
	 * Collaborateur
	 */
	@Autowired
	CollaborateurService collaborateurService;

	/**
	 * vehiculePersonnelService : Accès aux méthodes de service de la classe
	 * VehiculePersonnel
	 */
	@Autowired
	VehiculePersonnelService vehiculePersonnelService;

	@Autowired
	private JavaMailSender mailSender;

	/**
	 * Création d'une annonce de covoiturage : Vérifie si les adresses sont en bases
	 * et si le nombre de places définies est cohérent
	 * 
	 * @param createCovoiturage
	 * @return
	 * @throws BadRequestException
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
	 * Modification d'une annonce de covoiturage: Vérifie si les adresses sont en
	 * bases, si le nombre de places définies est cohérent et s'il possède des
	 * particpants auquel cas il ne peut être modifié
	 * 
	 * @param updateCovoiturage
	 * @return
	 */
	public Covoiturage update(@Valid Covoiturage updateCovoiturage) {

		if (updateCovoiturage.getId() == null) {
			throw new RuntimeException("erreur : le covoiturage n'est pas encore créer");
		}

		CovoiturageUtils.adresseChecker(updateCovoiturage);
		CovoiturageUtils.placesChecker(updateCovoiturage);
		CovoiturageUtils.updatePlaces(updateCovoiturage);

		if (updateCovoiturage.getNbPersonnes() != 1) {

			throw new RuntimeException(
					"Erreur : le covoiturage possède déja des participants il ne peut donc pas être modifié");
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

		List<Collaborateur> collaborateursToRemove = new ArrayList<>();
		Covoiturage covoiturageToUpdate = findById(id);
		for (Collaborateur collaborateur : covoiturageToUpdate.getCollaborateurs()) {
			if (collaborateur.getId().equals(collaborateurId)) {
				collaborateursToRemove.add(collaborateur);
				covoiturageToUpdate.setPlacesRestantes(covoiturageToUpdate.getPlacesRestantes() + 1);
				covoiturageToUpdate.setNbPersonnes(covoiturageToUpdate.getNbPersonnes() - 1);
			}
		}
		covoiturageToUpdate.getCollaborateurs().removeAll(collaborateursToRemove);

		return covoiturageRepository.save(covoiturageToUpdate);
	}

	/**
	 * Liste tous les covoiturages en base de données
	 * 
	 * @method findAll()
	 */
	public List<Covoiturage> findAll() {

		return covoiturageRepository.findAll();
	}

	/**
	 * 
	 * Retrouve les covoiturages pour un collaborateur donné en fonction de l'état
	 * "en-cours" (futur) ou "historique" (passé)
	 * 
	 * @param id
	 * @param state
	 * @return
	 * @throws BadRequestException
	 */
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

	/**
	 * 
	 * Recherche un covoiturage en fonction de 3 critères : L'adresse de départ,
	 * l'adresse d'arrivée et la date départ
	 * 
	 * @param collaborateurId
	 * @param adresseDepart
	 * @param adresseArrivee
	 * @param dateDepart
	 * @return
	 * @throws BadRequestException
	 */
	public List<Covoiturage> findByCriteres(Integer collaborateurId, Integer adresseDepartId, Integer adresseArriveeId,
			String dateDepart) throws BadRequestException {
		if (adresseDepartId == 0 && adresseArriveeId == 0 && dateDepart.equals("none")) {
			throw new BadRequestException("Veuillez saisir au moins un critère de recherche");
		} else if (adresseDepartId == 0 && adresseArriveeId == 0) {
			LocalDate dateDepartTime = DateUtils.stringToLocalDate(dateDepart);

			// Recherche les covoiturages compris entre le début et la fin d'une journée
			// donnée
			List<Covoiturage> covoiturages = covoiturageRepository.findBeetweenStartOfDaytAndEndOfDay(
					dateDepartTime.atTime(LocalTime.MIDNIGHT), dateDepartTime.atTime(LocalTime.MAX));

			// Retrait des covoiturages dont le collaborateur est chauffeur ou participant

			CovoiturageUtils.filtrerAffichage(collaborateurId, covoiturages);

			return covoiturages;

			// Seule l'adresse de départ est renseignée
		} else if (adresseArriveeId == 0) {
			LocalDate dateDepartTime = DateUtils.stringToLocalDate(dateDepart);

			List<Covoiturage> covoiturages = covoiturageRepository
					.findBeetweenStartOfDaytAndEndOfDayAndAdresseDepartOrAdresseArrivee(
							dateDepartTime.atTime(LocalTime.MIDNIGHT), dateDepartTime.atTime(LocalTime.MAX),
							adresseDepartId, Integer.MAX_VALUE);

			CovoiturageUtils.filtrerAffichage(collaborateurId, covoiturages);

			return covoiturages;

			// Seule l'adresse d'arrivée est renseignée
		} else if (adresseDepartId == 0) {
			LocalDate dateDepartTime = DateUtils.stringToLocalDate(dateDepart);

			List<Covoiturage> covoiturages = covoiturageRepository
					.findBeetweenStartOfDaytAndEndOfDayAndAdresseDepartOrAdresseArrivee(
							dateDepartTime.atTime(LocalTime.MIDNIGHT), dateDepartTime.atTime(LocalTime.MAX),
							Integer.MAX_VALUE, adresseArriveeId);

			CovoiturageUtils.filtrerAffichage(collaborateurId, covoiturages);

			return covoiturages;

			// Tout est renseigné
		} else if (adresseDepartId != 0 && adresseArriveeId != 0) {

			LocalDate dateDepartTime = DateUtils.stringToLocalDate(dateDepart);

			List<Covoiturage> covoiturages = covoiturageRepository
					.findBeetweenStartOfDaytAndEndOfDayAndAdresseDepartAndAdresseArrivee(
							dateDepartTime.atTime(LocalTime.MIDNIGHT), dateDepartTime.atTime(LocalTime.MAX),
							adresseDepartId, adresseArriveeId);

			CovoiturageUtils.filtrerAffichage(collaborateurId, covoiturages);

			return covoiturages;
		} else {
			throw new BadRequestException("Requête Invalide");
		}

	}

	/**
	 * Méthode qui retrouve un covoiturage en fonction de son id
	 * 
	 * @param id
	 * @return
	 */
	public Covoiturage findById(Integer id) {
		return this.covoiturageRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Le covoiturage recherché n'existe pas"));
	}

	/**
	 * Méthode qui efface un covoiturage en base en fonction de son id
	 * 
	 * @param id
	 */
	public void delete(Integer id) {

		if (id == null) {
			throw new RuntimeException("erreur : id covoiturage pas present");
		}

		Optional<Covoiturage> validCovoiturage = covoiturageRepository.findById(id)
				.filter(c -> c.getDateDepart().isAfter(LocalDateTime.now()));
		if (validCovoiturage.isPresent()) {
			deleteAndNotify(validCovoiturage.get());
		} else {
			throw new BadRequestException("Vous ne pouvez pas supprimmer un covoiturage passé");
		}

	}

	public void deleteAndNotify(Covoiturage covoiturage) {

		List<String> mailAdresses = new ArrayList<>();

		covoiturage.getCollaborateurs().forEach(c -> mailAdresses.add(c.getMail()));

		String[] mails = new String[mailAdresses.size()];

		mailAdresses.toArray(mails);

		String dateDepart = DateUtils.localDateTimeToString(covoiturage.getDateDepart());
		String organisateur = covoiturage.getOrganisateur().getPrenom() + " " + covoiturage.getOrganisateur().getNom();

		String genericText = "Cher covoitureur,\n\nNous sommes au regret de vous annoncer que votre covoiturage du "
				+ dateDepart + " n'aura pas lieu car il a été annulé par son organisateur " + organisateur
				+ ".\nNous vous prions de bien vouloir nous excuser pour le désagrément et espérons que vous pourrez trouver une solution alternative.\n\n"
				+ "Nous vous remercions de votre confiance et espérons vous revoir bientôt sur GP3 Covoiturage Series\n\n"
				+ "Bien cordialement,\n\n"
				+ "GP3C";

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("admin@gp3covoiturageseries.com");
		mailMessage.setTo(mails);
		mailMessage.setSubject("Annulation de votre covoiturage du " + dateDepart);
		mailMessage.setText(genericText);
		mailSender.send(mailMessage);
		this.covoiturageRepository.deleteById(covoiturage.getId());
	}

	public void deleteAfterDate(Integer id, LocalDate dateDepart) {

		LocalDate ajd = LocalDate.now();
		if (dateDepart.isEqual(ajd) || dateDepart.isAfter(ajd)) {

		}
		this.covoiturageRepository.deleteById(id);
	}

	/**
	 * 
	 * Recherche une annonce de covoiturage en fonction d'un chauffeur et d'un
	 * statut "en-cours" (futur) ou "passé"(historique)
	 * 
	 * @param id
	 * @param statut
	 * @return
	 * @throws FunctionalException
	 */
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

	public void annulerCovoit(Integer id, Integer idOrganisateur) {
		Collaborateur organisateur = new Collaborateur();
		for (Covoiturage covoit : organisateur.getAnnonces()) {
			if (organisateur.getId().equals(idOrganisateur)) {
				if (organisateur.getAnnonces().equals(id) && covoit.getDateDepart().isAfter(LocalDateTime.now())) {
					covoiturageRepository.delete(organisateur.getAnnonces().get(id));
				}
			}
		}
	}

}
