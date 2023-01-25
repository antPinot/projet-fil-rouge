package fr.diginamic.GP3Covoiturage.models;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.GP3Covoiturage.enums.Categorie;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

/** Classe Athlete 
 * 
 * @author Quentin
 */

@Table(name="VehiculeSociete")
public class VehiculeSociete {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="immatriculation", length = 9, nullable= false, unique= true)
	private String immatriculation;
	
	@Column(name="marque", length = 100, nullable= false)
	private String marque;
	
	@Column(name="modele", length = 100, nullable= false)
	private String modele;
	
	@Column(name="places", length = 1, nullable= false)
	@Size(max = 9)
	private int places;
	
	@Column(name="photo", length = 255, nullable= false)
	private String photo;
	
	@Column(name="disponible", length = 1, nullable= false)
	private int disponible;
	
	@Column(name="statut", length = 1, nullable= false)
	private int statut;
	
	@ManyToOne
	@JoinColumn(name = "id_Categorie")
	public Categorie categorie;
	
	@OneToMany(mappedBy = "vehiculeSociete")
	public List<ReservationVehicule> reservationsVehicule = new ArrayList<ReservationVehicule>();
	
	public VehiculeSociete() {
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
	 */
	public VehiculeSociete(int id, String immatriculation, String marque, String modele, @Size(max = 9) int places,
			String photo, int disponible, int statut) {
		super();
		this.id = id;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.places = places;
		this.photo = photo;
		this.disponible = disponible;
		this.statut = statut;
	}

	/**
	 * Getter pour l'attribut id
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter pour l'attribut id
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * Setter pour l'attribut categorie
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/**
	 * Getter pour l'attribut reservationsVehicule
	 * @return the reservationsVehicule
	 */
	public List<ReservationVehicule> getReservationsVehicule() {
		return reservationsVehicule;
	}

	/**
	 * Setter pour l'attribut reservationsVehicule
	 * @param reservationsVehicule the reservationsVehicule to set
	 */
	public void setReservationsVehicule(List<ReservationVehicule> reservationsVehicule) {
		this.reservationsVehicule = reservationsVehicule;
	}
	
}
