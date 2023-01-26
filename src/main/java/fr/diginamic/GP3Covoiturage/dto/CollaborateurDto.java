package fr.diginamic.GP3Covoiturage.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import fr.diginamic.GP3Covoiturage.models.Covoiturage;
import fr.diginamic.GP3Covoiturage.models.Role;
import fr.diginamic.GP3Covoiturage.models.VehiculePersonnel;

/** Classe CollaborateurDto
 * 
 * @author Quentin
 */

public class CollaborateurDto {
	
	private int id;
	
	private int matricule;

	private String nom;

	private String prenom;

	private String dateNaissance;

	private int telephone;

	private String mail;

	private String login;

	private String password;

	private String dateCreation;
	
	private List<VehiculePersonnelDto> vehiculesPersonnel = new ArrayList<VehiculePersonnelDto>();
	
	private List<RoleDto> roles = new ArrayList<RoleDto>();
	
	private List<CovoiturageDto> covoiturages = new ArrayList<CovoiturageDto>();
	
	public CollaborateurDto() {
		super();
	}

	/**
	 * @param matricule
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param telephone
	 * @param mail
	 * @param login
	 * @param password
	 * @param dateCreation
	 * @param vehiculesPersonnel
	 * @param roles
	 * @param covoiturages
	 */
	public CollaborateurDto(int matricule, String nom, String prenom, String dateNaissance, int telephone, String mail,
			String login, String password, String dateCreation, List<VehiculePersonnelDto> vehiculesPersonnel,
			List<RoleDto> roles, List<CovoiturageDto> covoiturages) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
		this.mail = mail;
		this.login = login;
		this.password = password;
		this.dateCreation = dateCreation;
		this.vehiculesPersonnel = vehiculesPersonnel;
		this.roles = roles;
		this.covoiturages = covoiturages;
	}
	
}
