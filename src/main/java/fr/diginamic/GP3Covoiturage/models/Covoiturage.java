package fr.diginamic.GP3Covoiturage.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author Fekhreddine
 */
@Entity
@Table(name = "Covoiturage")
public class Covoiturage {

	/**
	 * les entites de la classe
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "dateDepart")
	private LocalDate dateDepart;

	@Column(length = 2)
	private Integer placesRestantes;

	@Column(length = 2)
	private Integer nbPersonnes;

	@Column(length = 4)
	private Integer dureeTrajet;

	@Column(length = 4)
	private Integer distance;

	
	
	
	/**
	 * relation many to one avec autres classes
	 */
	@ManyToOne
	@JoinColumn(name = "idOrganisateur")
	private Collaborateur organisateur;

	@ManyToOne
	@JoinColumn(name = "VehiculePersonnel_id")
	private VehiculePersonnel vehiculePersonnel;

	@ManyToOne
	@JoinColumn(name = "idAdresseDepart")
	private Adresse adresseDepart;

	@ManyToOne
	@JoinColumn(name = "idAdresseArrivee")
	private Adresse idAdresseArrivee;

	/**
	 * relation many to many avec collaborateur
	 */
	@ManyToMany
	@JoinTable(name = "Participation", joinColumns = @JoinColumn(name = "Covoiturageid", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Collaborateurid", referencedColumnName = "id"))

	List<Collaborateur> collaborateurs = new ArrayList<>();

	/**
	 * relation many to one avec adresse
	 */
	@ManyToOne
	private Adresse adresse;

	/**
	 * relation many to one avec Vehicule_Personnel
	 */
	@ManyToOne
	private VehiculePersonnel vehicule_Personnel;

	/**
	 * constructeur avec les entites
	 */
	public Covoiturage(LocalDate dateDepart, Integer placesRestantes, Integer nbPersonnes, Integer dureeTrajet,
			Integer distance, Integer idOrganisateur, Integer vehiculePersonnelId, Integer idAdresseDepart,
			Integer idAdresseArrivee) {
		super();
		this.dateDepart = dateDepart;
		this.placesRestantes = placesRestantes;
		this.nbPersonnes = nbPersonnes;
		this.dureeTrajet = dureeTrajet;
		this.distance = distance;
		this.idOrganisateur = idOrganisateur;
		this.vehiculePersonnelId = vehiculePersonnelId;
		this.idAdresseDepart = idAdresseDepart;
		this.idAdresseArrivee = idAdresseArrivee;
	}

	/**
	 * constructeur vide pour JPA
	 */
	public Covoiturage() {
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
	public LocalDate getDateDepart() {
		return dateDepart;
	}

	/**
	 * @param dateDepart the dateDepart to set
	 */
	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	/**
	 * @return placesRestantes
	 */
	public Integer getPlacesRestantes() {
		return placesRestantes;
	}

	/**
	 * @param PlacesRestantes the PlacesRestantes to set
	 */
	public void setPlacesRestantes(Integer placesRestantes) {
		this.placesRestantes = placesRestantes;
	}

	/**
	 * @return NbPersonnes
	 */
	public Integer getNbPersonnes() {
		return nbPersonnes;
	}

	/**
	 * @param NbPersonnes the NbPersonnes to set
	 */
	public void setNbPersonnes(Integer nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}

	/**
	 * @return DureeTrajet
	 */
	public Integer getDureeTrajet() {
		return dureeTrajet;
	}

	/**
	 * @param DureeTrajet the DureeTrajet to set
	 */
	public void setDureeTrajet(Integer dureeTrajet) {
		this.dureeTrajet = dureeTrajet;
	}

	/**
	 * @return distance
	 */
	public Integer getDistance() {
		return distance;
	}

	/**
	 * @param Distance the Distance to set
	 */
	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	/**
	 * @return idOrganisateur
	 */
	public Integer getIdOrganisateur() {
		return idOrganisateur;
	}

	/**
	 * @param idOrganisateur the idOrganisateur to set
	 */
	public void setIdOrganisateur(Integer idOrganisateur) {
		this.idOrganisateur = idOrganisateur;
	}

	/**
	 * @return vehiculePersonnelId
	 */
	public Integer getVehiculePersonnelId() {
		return vehiculePersonnelId;
	}

	/**
	 * @param vehiculePersonnelId the vehiculePersonnelId to set
	 */
	public void setVehiculePersonnelId(Integer vehiculePersonnelId) {
		this.vehiculePersonnelId = vehiculePersonnelId;
	}

	/**
	 * @return idAdresseDepart
	 */
	public Integer getIdAdresseDepart() {
		return idAdresseDepart;
	}

	/**
	 * @param idAdresseDepart the idAdresseDepart to set
	 */
	public void setIdAdresseDepart(Integer idAdresseDepart) {
		this.idAdresseDepart = idAdresseDepart;
	}

	/**
	 * @return idAdresseArrivee
	 */
	public Integer getIdAdresseArrivee() {
		return idAdresseArrivee;
	}

	/**
	 * @param idAdresseArrivee the idAdresseArrivee to set
	 */
	public void setIdAdresseArrivee(Integer idAdresseArrivee) {
		this.idAdresseArrivee = idAdresseArrivee;
	}

	/**
	 * @return the collaborateurs
	 */
	public List<Collaborateur> getCollaborateurs() {
		return collaborateurs;
	}

	/**
	 * @param collaborateurs the collaborateurs to set
	 */
	public void setCollaborateurs(List<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * methode toString
	 */
	@Override
	public String toString() {
		return "Covoiturage [id=" + id + ", dateDepart=" + dateDepart + ", placesRestantes=" + placesRestantes
				+ ", nbPersonnes=" + nbPersonnes + ", dureeTrajet=" + dureeTrajet + ", distance=" + distance
				+ ", idOrganisateur=" + idOrganisateur + ", vehiculePersonnelId=" + vehiculePersonnelId
				+ ", idAdresseDepart=" + idAdresseDepart + ", idAdresseArrivee=" + idAdresseArrivee + "]";
	}

}
