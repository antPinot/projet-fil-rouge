package fr.diginamic.GP3Covoiturage.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;

/** Classe VehiculePersonnel
 * 
 * @author Quentin
 */

@Entity
@Table(name="VehiculePersonnel")
public class VehiculePersonnel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="immatriculation", length = 9, nullable= false, unique= true)
	private String immatriculation;
	
	@Column(name="marque", length = 100, nullable= false)
	private String marque;
	
	@Column(name="modele", length = 100, nullable= false)
	private String modele;
	
	@Column(name="places", length = 1, nullable= false)
	@Max(value = 9)
	private Integer places;
	
	@Column(name="limitePlace", length = 1, nullable= false)
	private Integer limitePlace;
	
	@OneToMany(mappedBy = "vehiculePersonnel")
	private List<Covoiturage> covoiturages = new ArrayList<Covoiturage>();
	
	@ManyToMany(mappedBy = "vehiculesPersonnel")
	private List<Collaborateur> collaborateurs = new ArrayList<Collaborateur>();

	public VehiculePersonnel() {
		super();
	}

	/**
	 * @param id
	 * @param immatriculation
	 * @param marque
	 * @param modele
	 * @param places
	 * @param limitePlace
	 * @param covoiturages
	 * @param collaborateurs
	 */
	public VehiculePersonnel(Integer id, String immatriculation, String marque, String modele, @Max(value = 9) Integer places,
			Integer limitePlace, List<Covoiturage> covoiturages, List<Collaborateur> collaborateurs) {
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
	public Integer getPlaces() {
		return places;
	}

	/**
	 * Setter pour l'attribut places
	 * @param places the places to set
	 */
	public void setPlaces(Integer places) {
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

	/**
	 * Getter pour l'attribut covoiturages
	 * @return the covoiturages
	 */
	public List<Covoiturage> getCovoiturages() {
		return covoiturages;
	}

	/**
	 * Setter pour l'attribut covoiturages
	 * @param covoiturages the covoiturages to set
	 */
	public void setCovoiturages(List<Covoiturage> covoiturages) {
		this.covoiturages = covoiturages;
	}

	/**
	 * Getter pour l'attribut collaborateurs
	 * @return the collaborateurs
	 */
	public List<Collaborateur> getCollaborateurs() {
		return collaborateurs;
	}

	/**
	 * Setter pour l'attribut collaborateurs
	 * @param collaborateurs the collaborateurs to set
	 */
	public void setCollaborateurs(List<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

}
