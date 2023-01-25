/**
 * 
 */
package fr.diginamic.GP3Covoiturage.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * @author antPinot
 * 
 *         Modèle de l'entité ReservationVehicule qui représente une réservation
 *         de véhicule de société
 *
 */

@Entity
@Table(name = "reservation_vehicule")
public class ReservationVehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** Date de début de la réservation */
	@Column(name = "date_depart", nullable = false)
	@NotNull
	private LocalDateTime dateDepart;

	/** Date de fin de la réservation */
	@Column(name = "date_retour", nullable = false)
	@NotNull
	private LocalDateTime dateRetour;

	/** Collaborateur effectuant la réservation */
	@ManyToOne
	@JoinColumn(name = "collaborateur_id")
	private Collaborateur collaborateur;

	/** Véhicule de société faisant l'objet de la réservation */
	@ManyToOne
	@JoinColumn(name = "vehicule_societe_id")
	private VehiculeSociete vehiculeSociete;

	/**
	 * 
	 * Constructeur vide pour JPA
	 *
	 */
	public ReservationVehicule() {

	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param dateDepart
	 * @param dateRetour
	 * @param photo
	 * @param collaborateur
	 * @param vehiculeSociete
	 */
	public ReservationVehicule(Integer id, @NotNull LocalDateTime dateDepart, @NotNull LocalDateTime dateRetour,
			Collaborateur collaborateur, VehiculeSociete vehiculeSociete) {
		this.id = id;
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;

		this.collaborateur = collaborateur;
		this.vehiculeSociete = vehiculeSociete;
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
	public LocalDateTime getDateDepart() {
		return dateDepart;
	}

	/**
	 * Setter pour l'attribut dateDepart
	 * 
	 * @param dateDepart the dateDepart to set
	 */
	public void setDateDepart(LocalDateTime dateDepart) {
		this.dateDepart = dateDepart;
	}

	/**
	 * Getter pour l'attribut dateRetour
	 * 
	 * @return the dateRetour
	 */
	public LocalDateTime getDateRetour() {
		return dateRetour;
	}

	/**
	 * Setter pour l'attribut dateRetour
	 * 
	 * @param dateRetour the dateRetour to set
	 */
	public void setDateRetour(LocalDateTime dateRetour) {
		this.dateRetour = dateRetour;
	}

	/**
	 * Getter pour l'attribut collaborateur
	 * 
	 * @return the collaborateur
	 */
	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	/**
	 * Setter pour l'attribut collaborateur
	 * 
	 * @param collaborateur the collaborateur to set
	 */
	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	/**
	 * Getter pour l'attribut vehiculeSociete
	 * 
	 * @return the vehiculeSociete
	 */
	public VehiculeSociete getVehiculeSociete() {
		return vehiculeSociete;
	}

	/**
	 * Setter pour l'attribut vehiculeSociete
	 * 
	 * @param vehiculeSociete the vehiculeSociete to set
	 */
	public void setVehiculeSociete(VehiculeSociete vehiculeSociete) {
		this.vehiculeSociete = vehiculeSociete;
	}

}
