package fr.diginamic.GP3Covoiturage.dto.dtoLight;

import java.util.List;

import fr.diginamic.GP3Covoiturage.dto.AdresseDto;
import fr.diginamic.GP3Covoiturage.dto.CollaborateurDto;
import fr.diginamic.GP3Covoiturage.dto.VehiculePersonnelDto;

/**
 * @author Fekhreddine
 */
public class CovoiturageDtoLight {

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

	private CollaborateurDtoLight organisateur;

	private VehiculePersonnelDtoLight vehiculePersonnel;

	private AdresseDtoLight adresseDepart;

	private AdresseDtoLight adresseArrivee;

	private List<CollaborateurDtoLight> collaborateurs;

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param dateDepart
	 * @param placesRestantes
	 * @param nbPersonnes
	 * @param dureeTrajet
	 * @param distance
	 * @param organisateur
	 * @param vehiculePersonnel
	 * @param adresseDepart
	 * @param adresseArrivee
	 * @param collaborateurs
	 */
	public CovoiturageDtoLight(Integer id, String dateDepart, Integer placesRestantes, Integer nbPersonnes,
			Integer dureeTrajet, Integer distance, CollaborateurDtoLight organisateur,
			VehiculePersonnelDtoLight vehiculePersonnel, AdresseDtoLight adresseDepart, AdresseDtoLight adresseArrivee,
			List<CollaborateurDtoLight> collaborateurs) {
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
	 * constructeur
	 */
	public CovoiturageDtoLight() {
	}

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
	 * @return the placesRestantes
	 */
	public Integer getPlacesRestantes() {
		return placesRestantes;
	}

	/**
	 * @param placesRestantes the placesRestantes to set
	 */
	public void setPlacesRestantes(Integer placesRestantes) {
		this.placesRestantes = placesRestantes;
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
	public CollaborateurDtoLight getOrganisateur() {
		return organisateur;
	}

	/**
	 * @param organisateur the organisateur to set
	 */
	public void setOrganisateur(CollaborateurDtoLight organisateur) {
		this.organisateur = organisateur;
	}

	/**
	 * @return the vehiculePersonnel
	 */
	public VehiculePersonnelDtoLight getVehiculePersonnel() {
		return vehiculePersonnel;
	}

	/**
	 * @param vehiculePersonnel the vehiculePersonnel to set
	 */
	public void setVehiculePersonnel(VehiculePersonnelDtoLight vehiculePersonnel) {
		this.vehiculePersonnel = vehiculePersonnel;
	}

	/**
	 * @return the adresseDepart
	 */
	public AdresseDtoLight getAdresseDepart() {
		return adresseDepart;
	}

	/**
	 * @param adresseDepart the adresseDepart to set
	 */
	public void setAdresseDepart(AdresseDtoLight adresseDepart) {
		this.adresseDepart = adresseDepart;
	}

	/**
	 * @return the adresseArrivee
	 */
	public AdresseDtoLight getAdresseArrivee() {
		return adresseArrivee;
	}

	/**
	 * @param adresseArrivee the adresseArrivee to set
	 */
	public void setAdresseArrivee(AdresseDtoLight adresseArrivee) {
		this.adresseArrivee = adresseArrivee;
	}

	/**
	 * Getter pour l'attribut collaborateurs
	 * 
	 * @return the collaborateurs
	 */
	public List<CollaborateurDtoLight> getCollaborateurs() {
		return collaborateurs;
	}

	/**
	 * Setter pour l'attribut collaborateurs
	 * 
	 * @param collaborateurs the collaborateurs to set
	 */
	public void setCollaborateurs(List<CollaborateurDtoLight> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

}
