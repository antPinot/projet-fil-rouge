package fr.diginamic.GP3Covoiturage.dto;

import java.util.ArrayList;
import java.util.List;

/** Classe VehiculeSocieteDto
 * 
 * @author Quentin
 */

public class VehiculeSocieteDto {
	
	private Integer id;
	
	private String immatriculation;
	
	private String marque;
	
	private String modele;
	
	private int places;
	
	private String photo;
	
	private int disponible;
	
	private int statut;
	
	private String categorie;
	
	private List<ReservationVehiculeDto> reservationsVehicule = new ArrayList<ReservationVehiculeDto>();

	public VehiculeSocieteDto() {
		super();
	}

	/**
	 * @param id
	 * @param immatriculation
	 * @param marque
	 * @param modele
	 * @param places
	 * @param photo
	 * @param disponible
	 * @param statut
	 * @param categorie
	 */
	public VehiculeSocieteDto(Integer id, String immatriculation, String marque, String modele, int places, String photo,
			int disponible, int statut, String categorie, List<ReservationVehiculeDto> reservationsVehicule) {
		super();
		this.id = id;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.places = places;
		this.photo = photo;
		this.disponible = disponible;
		this.statut = statut;
		this.categorie = categorie;
		this.reservationsVehicule = reservationsVehicule;
	}

	/**
	 * Getter pour l'attribut id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter pour l'attribut id
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter pour l'attribut immatriculation
	 * @return the immatriculation
	 */
	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * Setter pour l'attribut immatriculation
	 * @param immatriculation the immatriculation to set
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	/**
	 * Getter pour l'attribut marque
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * Setter pour l'attribut marque
	 * @param marque the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * Getter pour l'attribut modele
	 * @return the modele
	 */
	public String getModele() {
		return modele;
	}

	/**
	 * Setter pour l'attribut modele
	 * @param modele the modele to set
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}

	/**
	 * Getter pour l'attribut places
	 * @return the places
	 */
	public int getPlaces() {
		return places;
	}

	/**
	 * Setter pour l'attribut places
	 * @param places the places to set
	 */
	public void setPlaces(int places) {
		this.places = places;
	}

	/**
	 * Getter pour l'attribut photo
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * Setter pour l'attribut photo
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * Getter pour l'attribut disponible
	 * @return the disponible
	 */
	public int getDisponible() {
		return disponible;
	}

	/**
	 * Setter pour l'attribut disponible
	 * @param disponible the disponible to set
	 */
	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	/**
	 * Getter pour l'attribut statut
	 * @return the statut
	 */
	public int getStatut() {
		return statut;
	}

	/**
	 * Setter pour l'attribut statut
	 * @param statut the statut to set
	 */
	public void setStatut(int statut) {
		this.statut = statut;
	}

	/**
	 * Getter pour l'attribut categorie
	 * @return the categorie
	 */
	public String getCategorie() {
		return categorie;
	}

	/**
	 * Setter pour l'attribut categorie
	 * @param categorie the categorie to set
	 */
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	/**
	 * Getter pour l'attribut reservationsVehicule
	 * @return the reservationsVehicule
	 */
	public List<ReservationVehiculeDto> getReservationsVehicule() {
		return reservationsVehicule;
	}

	/**
	 * Setter pour l'attribut reservationsVehicule
	 * @param reservationsVehicule the reservationsVehicule to set
	 */
	public void setReservationsVehicule(List<ReservationVehiculeDto> reservationsVehicule) {
		this.reservationsVehicule = reservationsVehicule;
	}
	
}
