package fr.diginamic.GP3Covoiturage.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.GP3Covoiturage.models.Adresse;
import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.models.VehiculePersonnel;

/**
 * @author Fekhreddine
 */
public class CovoiturageDto {

	/**
	 * les entites de la classe
	 */

	private Integer id;

	private String dateDepart;

	private Integer placesRestantes;

	private Integer nbPersonnes;

	private Integer dureeTrajet;

	private Integer distance;

	/**
	 * relation many to one avec autres classes
	 */

	private CollaborateurDto organisateur;

	private VehiculePersonnelDto vehiculePersonnel;

	private AdresseDto adresseDepart;

	private AdresseDto adresseArrivee;

	/**
	 * relation many to many avec collaborateur
	 */
	private List<CollaborateurDto> collaborateurs = new ArrayList<>();

	/**
	 * constructeur avec les entites
	 */
	public CovoiturageDto(Integer id, LocalDate dateDepart, Integer placesRestantes, Integer nbPersonnes,
			Integer dureeTrajet, Integer distance, CollaborateurDto organisateur,
			VehiculePersonnelDto vehiculePersonnel, AdresseDto adresseDepart, AdresseDto adresseArrivee,
			List<CollaborateurDto> collaborateurs) {
		super();
		this.id = id;
		this.dateDepart = dateDepart;
		this.placesRestantes = placesRestantes;
		this.nbPersonnes = nbPersonnes;
		this.dureeTrajet = dureeTrajet;
		this.distance = distance;
		this.organisateur = organisateur;
		this.vehiculePersonnel = vehiculePersonnel;
		this.adresseDepart = adresseDepart;
		this.adresseArrivee = adresseArrivee;
		this.collaborateurs = collaborateurs;
	}

	/**
	 * constructeur vide pour JPA
	 */
	public CovoiturageDto() {
	}

	/**
	 * 
	 * 
	 * 
	 * Getters et Setters
	 * 
	 * 
	 * 
	 */
 
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the dateDepart
	 */
	public String getDateDepart() {
		return dateDepart;
	}

	/**
	 * @param dateDepart the dateDepart to set
	 */
	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	/**
	 * @return the nbPersonnes
	 */
	public Integer getNbPersonnes() {
		return nbPersonnes;
	}

	/**
	 * @param nbPersonnes the nbPersonnes to set
	 */
	public void setNbPersonnes(Integer nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}

	/**
	 * @return the dureeTrajet
	 */
	public Integer getDureeTrajet() {
		return dureeTrajet;
	}

	/**
	 * @param dureeTrajet the dureeTrajet to set
	 */
	public void setDureeTrajet(Integer dureeTrajet) {
		this.dureeTrajet = dureeTrajet;
	}

	/**
	 * @return the distance
	 */
	public Integer getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	/**
	 * @return the organisateur
	 */
	public CollaborateurDto getOrganisateur() {
		return organisateur;
	}

	/**
	 * @param organisateur the organisateur to set
	 */
	public void setOrganisateur(CollaborateurDto organisateur) {
		this.organisateur = organisateur;
	}

	/**
	 * @return the vehiculePersonnel
	 */
	public VehiculePersonnelDto getVehiculePersonnel() {
		return vehiculePersonnel;
	}

	/**
	 * @param vehiculePersonnel the vehiculePersonnel to set
	 */
	public void setVehiculePersonnel(VehiculePersonnelDto vehiculePersonnel) {
		this.vehiculePersonnel = vehiculePersonnel;
	}

	/**
	 * @return the adresseDepart
	 */
	public AdresseDto getAdresseDepart() {
		return adresseDepart;
	}

	/**
	 * @param adresseDepart the adresseDepart to set
	 */
	public void setAdresseDepart(AdresseDto adresseDepart) {
		this.adresseDepart = adresseDepart;
	}

	/**
	 * @return the adresseArrivee
	 */
	public AdresseDto getAdresseArrivee() {
		return adresseArrivee;
	}

	/**
	 * @param adresseArrivee the adresseArrivee to set
	 */
	public void setAdresseArrivee(AdresseDto adresseArrivee) {
		this.adresseArrivee = adresseArrivee;
	}

	/**
	 * @return the collaborateurs
	 */
	public List<CollaborateurDto> getCollaborateurs() {
		return collaborateurs;
	}

	/**
	 * @param collaborateurs the collaborateurs to set
	 */
	public void setCollaborateurs(List<CollaborateurDto> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

	/**
	 * @return the placesRestantes
	 */
	public Integer getPlacesRestantes() {
		return placesRestantes;
	}

	public void setPlacesRestantes(Integer placesRestantes) {
		this.placesRestantes = placesRestantes;
	}

}
