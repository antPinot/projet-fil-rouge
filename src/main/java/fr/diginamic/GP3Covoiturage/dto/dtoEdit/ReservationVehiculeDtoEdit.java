/**
 * 
 */
package fr.diginamic.GP3Covoiturage.dto.dtoEdit;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * DTO pour sauvegarder ou créer une réservation
 * 
 * @author antPinot
 *
 */

@Component
public class ReservationVehiculeDtoEdit {
	
	
	private Integer id;
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private String dateDepart;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private String dateRetour;
	
	@NotNull
	private Integer collaborateurId;
	
	@NotNull
	private Integer vehiculeSocieteId;

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
	 * Getter pour l'attribut collaborateurId
	 * 
	 * @return the collaborateurId
	 */
	public Integer getCollaborateurId() {
		return collaborateurId;
	}

	/**
	 * Setter pour l'attribut collaborateurId
	 * 
	 * @param collaborateurId the collaborateurId to set
	 */
	public void setCollaborateurId(Integer collaborateurId) {
		this.collaborateurId = collaborateurId;
	}

	/**
	 * Getter pour l'attribut vehiculeSocieteId
	 * 
	 * @return the vehiculeSocieteId
	 */
	public Integer getVehiculeSocieteId() {
		return vehiculeSocieteId;
	}

	/**
	 * Setter pour l'attribut vehiculeSocieteId
	 * 
	 * @param vehiculeSocieteId the vehiculeSocieteId to set
	 */
	public void setVehiculeSocieteId(Integer vehiculeSocieteId) {
		this.vehiculeSocieteId = vehiculeSocieteId;
	}

}
