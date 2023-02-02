/**
 * 
 */
package fr.diginamic.GP3Covoiturage.dto.dtoEdit;

import java.util.List;

/**
 * @author antPinot
 *
 */
public class CovoiturageDtoEdit {

	private Integer id;

	private String dateDepart;

	private Integer placesRestantes;

	private Integer nbPersonnes;

	private Integer dureeTrajet;

	private Integer distance;

	private Integer organisateurId;

	private Integer vehiculePersonnelId;

	private AdresseDtoEdit adresseDepart;

	private AdresseDtoEdit adresseArrivee;

	private List<Integer> collaborateursId;

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param dateDepart
	 * @param placesRestantes
	 * @param nbPersonnes
	 * @param dureeTrajet
	 * @param distance
	 * @param organisateurId
	 * @param vehiculePersonnelId
	 * @param adresseDepart
	 * @param adresseArrivee
	 * @param collaborateursId
	 */
	public CovoiturageDtoEdit(Integer id, String dateDepart, Integer placesRestantes, Integer nbPersonnes,
			Integer dureeTrajet, Integer distance, Integer organisateurId, Integer vehiculePersonnelId,
			AdresseDtoEdit adresseDepart, AdresseDtoEdit adresseArrivee, List<Integer> collaborateursId) {
		this.id = id;
		this.dateDepart = dateDepart;
		this.placesRestantes = placesRestantes;
		this.nbPersonnes = nbPersonnes;
		this.dureeTrajet = dureeTrajet;
		this.distance = distance;
		this.organisateurId = organisateurId;
		this.vehiculePersonnelId = vehiculePersonnelId;
		this.adresseDepart = adresseDepart;
		this.adresseArrivee = adresseArrivee;
		this.collaborateursId = collaborateursId;
	}

	/**
	 * Getter pour l'attribut id
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter pour l'attribut id
	 * 
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter pour l'attribut dateDepart
	 * 
	 * @return the dateDepart
	 */
	public String getDateDepart() {
		return dateDepart;
	}

	/**
	 * Setter pour l'attribut dateDepart
	 * 
	 * @param dateDepart the dateDepart to set
	 */
	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	/**
	 * Getter pour l'attribut placesRestantes
	 * 
	 * @return the placesRestantes
	 */
	public Integer getPlacesRestantes() {
		return placesRestantes;
	}

	/**
	 * Setter pour l'attribut placesRestantes
	 * 
	 * @param placesRestantes the placesRestantes to set
	 */
	public void setPlacesRestantes(Integer placesRestantes) {
		this.placesRestantes = placesRestantes;
	}

	/**
	 * Getter pour l'attribut nbPersonnes
	 * 
	 * @return the nbPersonnes
	 */
	public Integer getNbPersonnes() {
		return nbPersonnes;
	}

	/**
	 * Setter pour l'attribut nbPersonnes
	 * 
	 * @param nbPersonnes the nbPersonnes to set
	 */
	public void setNbPersonnes(Integer nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}

	/**
	 * Getter pour l'attribut dureeTrajet
	 * 
	 * @return the dureeTrajet
	 */
	public Integer getDureeTrajet() {
		return dureeTrajet;
	}

	/**
	 * Setter pour l'attribut dureeTrajet
	 * 
	 * @param dureeTrajet the dureeTrajet to set
	 */
	public void setDureeTrajet(Integer dureeTrajet) {
		this.dureeTrajet = dureeTrajet;
	}

	/**
	 * Getter pour l'attribut distance
	 * 
	 * @return the distance
	 */
	public Integer getDistance() {
		return distance;
	}

	/**
	 * Setter pour l'attribut distance
	 * 
	 * @param distance the distance to set
	 */
	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	/**
	 * Getter pour l'attribut organisateurId
	 * 
	 * @return the organisateurId
	 */
	public Integer getOrganisateurId() {
		return organisateurId;
	}

	/**
	 * Setter pour l'attribut organisateurId
	 * 
	 * @param organisateurId the organisateurId to set
	 */
	public void setOrganisateurId(Integer organisateurId) {
		this.organisateurId = organisateurId;
	}

	/**
	 * Getter pour l'attribut vehiculePersonnelId
	 * 
	 * @return the vehiculePersonnelId
	 */
	public Integer getVehiculePersonnelId() {
		return vehiculePersonnelId;
	}

	/**
	 * Setter pour l'attribut vehiculePersonnelId
	 * 
	 * @param vehiculePersonnelId the vehiculePersonnelId to set
	 */
	public void setVehiculePersonnelId(Integer vehiculePersonnelId) {
		this.vehiculePersonnelId = vehiculePersonnelId;
	}

	/**
	 * Getter pour l'attribut adresseDepart
	 * 
	 * @return the adresseDepart
	 */
	public AdresseDtoEdit getAdresseDepart() {
		return adresseDepart;
	}

	/**
	 * Setter pour l'attribut adresseDepart
	 * 
	 * @param adresseDepart the adresseDepart to set
	 */
	public void setAdresseDepart(AdresseDtoEdit adresseDepart) {
		this.adresseDepart = adresseDepart;
	}

	/**
	 * Getter pour l'attribut adresseArrivee
	 * 
	 * @return the adresseArrivee
	 */
	public AdresseDtoEdit getAdresseArrivee() {
		return adresseArrivee;
	}

	/**
	 * Setter pour l'attribut adresseArrivee
	 * 
	 * @param adresseArrivee the adresseArrivee to set
	 */
	public void setAdresseArrivee(AdresseDtoEdit adresseArrivee) {
		this.adresseArrivee = adresseArrivee;
	}

	/**
	 * Getter pour l'attribut collaborateursId
	 * 
	 * @return the collaborateursId
	 */
	public List<Integer> getCollaborateursId() {
		return collaborateursId;
	}

	/**
	 * Setter pour l'attribut collaborateursId
	 * 
	 * @param collaborateursId the collaborateursId to set
	 */
	public void setCollaborateursId(List<Integer> collaborateursId) {
		this.collaborateursId = collaborateursId;
	}

}
