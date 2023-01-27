package fr.diginamic.GP3Covoiturage.dto;

import java.util.ArrayList;
import java.util.List;

/** Classe VehiculePersonnelDto
 * 
 * @author Quentin
 */

public class VehiculePersonnelDto {
	
	private Integer id;
	
	private String immatriculation;
	
	private String marque;
	
	private String modele;
	
	private int places;
	
	private int limitePlace;
	
	private List<CovoiturageDto> covoiturages = new ArrayList<CovoiturageDto>();
	
	private List<CollaborateurDto> collaborateurs = new ArrayList<CollaborateurDto>();

	public VehiculePersonnelDto() {
		super();
	}

	/**
	 * @param immatriculation
	 * @param marque
	 * @param modele
	 * @param places
	 * @param limitePlace
	 * @param collaborateurs
	 */
	public VehiculePersonnelDto(Integer id, String immatriculation, String marque, String modele, int places, int limitePlace,
			List<CovoiturageDto> covoiturages, List<CollaborateurDto> collaborateurs) {
		super();
		this.id = id;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.places = places;
		this.limitePlace = limitePlace;
		this.covoiturages = covoiturages;
		this.collaborateurs = collaborateurs;
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
	 * Getter pour l'attribut limitePlace
	 * @return the limitePlace
	 */
	public int getLimitePlace() {
		return limitePlace;
	}

	/**
	 * Setter pour l'attribut limitePlace
	 * @param limitePlace the limitePlace to set
	 */
	public void setLimitePlace(int limitePlace) {
		this.limitePlace = limitePlace;
	}
	
	/**
	 * Getter pour l'attribut covoiturages
	 * @return the covoiturages
	 */
	public List<CovoiturageDto> getCovoiturages() {
		return covoiturages;
	}

	/**
	 * Setter pour l'attribut covoiturages
	 * @param covoiturages the covoiturages to set
	 */
	public void setCovoiturages(List<CovoiturageDto> covoiturages) {
		this.covoiturages = covoiturages;
	}

	/**
	 * Getter pour l'attribut collaborateurs
	 * @return the collaborateurs
	 */
	public List<CollaborateurDto> getCollaborateurs() {
		return collaborateurs;
	}

	/**
	 * Setter pour l'attribut collaborateurs
	 * @param collaborateurs the collaborateurs to set
	 */
	public void setCollaborateurs(List<CollaborateurDto> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}
	
}
