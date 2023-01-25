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
	private Adresse adresseArrivee;

	/**
	 * relation many to many avec collaborateur
	 */
	@ManyToMany
	@JoinTable(name = "Participation", 
	joinColumns = @JoinColumn(name = "Covoiturageid", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "Collaborateurid", referencedColumnName = "id"))

	private List<Collaborateur> collaborateurs = new ArrayList<>();

	

	/**
	 * constructeur avec les entites
	 */
	public Covoiturage(Integer id, LocalDate dateDepart, Integer placesRestantes, Integer nbPersonnes,
			Integer dureeTrajet, Integer distance, Collaborateur organisateur, VehiculePersonnel vehiculePersonnel,
			Adresse adresseDepart, Adresse adresseArrivee, List<Collaborateur> collaborateurs, Adresse adresse,
			VehiculePersonnel vehicule_Personnel) {
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
	public Collaborateur getOrganisateur() {
		return organisateur;
	}

	/**
	 * @param idOrganisateur the idOrganisateur to set
	 */
	public void setOrganisateur(Collaborateur organisateur) {
		this.organisateur = organisateur;
	}

	/**
	 * @return vehiculePersonnelId
	 */
	public VehiculePersonnel getVehiculePersonnel() {
		return vehiculePersonnel;
	}

	/**
	 * @param vehiculePersonnelId the vehiculePersonnelId to set
	 */
	public void setVehiculePersonnel(VehiculePersonnel vehiculePersonnel) {
		this.vehiculePersonnel = vehiculePersonnel;
	}

	

	

	/**
	 * @return adresseArrivee
	 */

	/**
	 * @param adresseArrivee the adresseArrivee to set
	 */

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
	 * @return the adresseArrivee
	 */
	public Adresse getAdresseArrivee() {
		return adresseArrivee;
	}

	/**
	 * @param adresseArrivee the adresseArrivee to set
	 */
	public void setAdresseArrivee(Adresse adresseArrivee) {
		this.adresseArrivee = adresseArrivee;
	}

	
	
	
	/**
	 * @return adresseDepart
	 */
	public Adresse getAdresseDepart() {
		return adresseDepart;
	}

	/**
	 * @param adresseDepart the adresseDepart to set
	 */
	public void setAdresseDepart(Adresse adresseDepart) {
		this.adresseDepart = adresseDepart;
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
				+ ", organisateur=" + organisateur + ", vehiculePersonnel=" + vehiculePersonnel + ", adresseDepart="
				+ adresseDepart + ", adresseArrivee=" + adresseArrivee + ", collaborateurs=" + collaborateurs
				+ "]";
	}

}
