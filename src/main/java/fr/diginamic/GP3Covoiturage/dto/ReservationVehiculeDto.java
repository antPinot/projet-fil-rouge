/**
 * 
 */
package fr.diginamic.GP3Covoiturage.dto;

import fr.diginamic.GP3Covoiturage.dto.dtoLight.CollaborateurDtoLight;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.VehiculeSocieteDtoLight;

/**
 * @author antPinot
 * 
 *         Dto correspondant à l'entité ReservationVehicule
 *
 */

public class ReservationVehiculeDto {

	/**
	 * Getter pour l'attribut vehiculeSociete
	 * 
	 * @return the vehiculeSociete
	 */
	public VehiculeSocieteDtoLight getVehiculeSociete() {
		return vehiculeSociete;
	}

	/**
	 * Setter pour l'attribut vehiculeSociete
	 * 
	 * @param vehiculeSociete the vehiculeSociete to set
	 */
	public void setVehiculeSociete(VehiculeSocieteDtoLight vehiculeSociete) {
		this.vehiculeSociete = vehiculeSociete;
	}

	/** id */
	private Integer id;

	/** dateDepart */
	private String dateDepart;

	/** dateRetour */
	private String dateRetour;

	/** collaborateur */
	private CollaborateurDtoLight collaborateur;

	/** vehiculeSociete */
	private VehiculeSocieteDtoLight vehiculeSociete;

	/**
	 * 
	 * Constructeur vide pour JPA
	 *
	 */
	public ReservationVehiculeDto() {

	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param dateDepart
	 * @param dateRetour
	 * @param collaborateur
	 * @param vehiculeSociete
	 */
	public ReservationVehiculeDto(Integer id, String dateDepart, String dateRetour, CollaborateurDtoLight collaborateur,
			VehiculeSocieteDtoLight vehiculeSociete) {
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
	public String getDateDepart() {
		return dateDepart;
	}

	/**
	 * Setter pour l'attribut dateDepart
	 * 
	 * @param dateDepart the dateDepart to set
	 */
	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	/**
	 * Getter pour l'attribut dateRetour
	 * 
	 * @return the dateRetour
	 */
	public String getDateRetour() {
		return dateRetour;
	}

	/**
	 * Setter pour l'attribut dateRetour
	 * 
	 * @param dateRetour the dateRetour to set
	 */
	public void setDateRetour(String dateRetour) {
		this.dateRetour = dateRetour;
	}

	/**
	 * Getter pour l'attribut collaborateur
	 * 
	 * @return the collaborateur
	 */
	public CollaborateurDtoLight getCollaborateur() {
		return collaborateur;
	}

	/**
	 * Setter pour l'attribut collaborateur
	 * 
	 * @param collaborateur the collaborateur to set
	 */
	public void setCollaborateur(CollaborateurDtoLight collaborateur) {
		this.collaborateur = collaborateur;
	}

}
