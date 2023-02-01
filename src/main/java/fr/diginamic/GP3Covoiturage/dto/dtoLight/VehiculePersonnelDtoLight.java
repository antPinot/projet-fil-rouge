package fr.diginamic.GP3Covoiturage.dto.dtoLight;

public class VehiculePersonnelDtoLight {

	private Integer id;

	private String immatriculation;

	private String marque;

	private String modele;

	private Integer places;

	private Integer limitePlace;

	/**
	 * @param immatriculation
	 * @param marque
	 * @param modele
	 * @param places
	 * @param limitePlace
	 * 
	 */
	public VehiculePersonnelDtoLight(Integer id, String immatriculation, String marque, String modele, Integer places,
			Integer limitePlace) {
		super();
		this.id = id;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.places = places;
		this.limitePlace = limitePlace;
	}

	/** construct vide */
	public VehiculePersonnelDtoLight() {
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
	 * @return the immatriculation
	 */
	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * @param immatriculation the immatriculation to set
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	/**
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * @param marque the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * @return the modele
	 */
	public String getModele() {
		return modele;
	}

	/**
	 * @param modele the modele to set
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}

	/**
	 * @return the places
	 */
	public Integer getPlaces() {
		return places;
	}

	/**
	 * @param places the places to set
	 */
	public void setPlaces(Integer places) {
		this.places = places;
	}

	/**
	 * @return the limitePlace
	 */
	public Integer getLimitePlace() {
		return limitePlace;
	}

	/**
	 * @param limitePlace the limitePlace to set
	 */
	public void setLimitePlace(Integer limitePlace) {
		this.limitePlace = limitePlace;
	}

}
