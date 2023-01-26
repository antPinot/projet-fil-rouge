/**
 * 
 */
package fr.diginamic.GP3Covoiturage.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 * @author antPinot
 * 
 * Dto correspondant à l'entité ReservationVehicule
 *
 */

public class ReservationVehiculeDto {

	/** id */
	private Integer id;

	/** dateDepart */
	private String dateDepart;

	/** dateRetour */
	private String dateRetour;

	/** collaborateur */
	private CollaborateurDto collaborateur;

	/** vehiculeSociete */
	private VehiculeSocieteDto vehiculeSociete;

	/**
	 * 
	 * Constructeur vide pour JPA
	 *
	 */
	public ReservationVehiculeDto() {

	}

	/**Constructeur
	 * @param id
	 * @param dateDepart
	 * @param dateRetour
	 * @param collaborateur
	 * @param vehiculeSociete
	 */
	public ReservationVehiculeDto(Integer id, String dateDepart, String dateRetour, CollaborateurDto collaborateur,
			VehiculeSocieteDto vehiculeSociete) {
		this.id = id;
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.collaborateur = collaborateur;
		this.vehiculeSociete = vehiculeSociete;
	}

	/**Getter pour l'attribut id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**Setter pour l'attribut id
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**Getter pour l'attribut dateDepart
	 * @return the dateDepart
	 */
	public String getDateDepart() {
		return dateDepart;
	}

	/**Setter pour l'attribut dateDepart
	 * @param dateDepart the dateDepart to set
	 */
	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	/**Getter pour l'attribut dateRetour
	 * @return the dateRetour
	 */
	public String getDateRetour() {
		return dateRetour;
	}

	/**Setter pour l'attribut dateRetour
	 * @param dateRetour the dateRetour to set
	 */
	public void setDateRetour(String dateRetour) {
		this.dateRetour = dateRetour;
	}

	/**Getter pour l'attribut collaborateur
	 * @return the collaborateur
	 */
	public CollaborateurDto getCollaborateur() {
		return collaborateur;
	}

	/**Setter pour l'attribut collaborateur
	 * @param collaborateur the collaborateur to set
	 */
	public void setCollaborateur(CollaborateurDto collaborateur) {
		this.collaborateur = collaborateur;
	}

	/**Getter pour l'attribut vehiculeSociete
	 * @return the vehiculeSociete
	 */
	public VehiculeSocieteDto getVehiculeSociete() {
		return vehiculeSociete;
	}

	/**Setter pour l'attribut vehiculeSociete
	 * @param vehiculeSociete the vehiculeSociete to set
	 */
	public void setVehiculeSociete(VehiculeSocieteDto vehiculeSociete) {
		this.vehiculeSociete = vehiculeSociete;
	}
	

}
