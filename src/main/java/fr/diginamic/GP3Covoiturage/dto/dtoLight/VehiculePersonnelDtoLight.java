package fr.diginamic.GP3Covoiturage.dto.dtoLight;

/**
 * Classe Collaborateur
 * 
 * @author Quentin
 */

public class VehiculePersonnelDtoLight {
	
	private Integer id;

	private String immatriculation;

	private String marque;

	private String modele;

	private int places;

	private Integer limitePlace;

	/**
	 * @param id
	 * @param immatriculation
	 * @param marque
	 * @param modele
	 * @param places
	 * @param limitePlace
	 */
	public VehiculePersonnelDtoLight(Integer id, String immatriculation, String marque, String modele, int places,
			Integer limitePlace) {
		super();
		this.id = id;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.places = places;
		this.limitePlace = limitePlace;
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
	public Integer getLimitePlace() {
		return limitePlace;
	}

	/**
	 * Setter pour l'attribut limitePlace
	 * @param limitePlace the limitePlace to set
	 */
	public void setLimitePlace(Integer limitePlace) {
		this.limitePlace = limitePlace;
	}

}
