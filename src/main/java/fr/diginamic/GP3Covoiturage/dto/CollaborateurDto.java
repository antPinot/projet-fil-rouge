package fr.diginamic.GP3Covoiturage.dto;

import java.util.ArrayList;
import java.util.List;

/** Classe CollaborateurDto
 * 
 * @author Quentin
 */

public class CollaborateurDto {
	
	private Integer id;
	
	private Integer matricule;

	private String nom;

	private String prenom;

	private String dateNaissance;

	private Integer telephone;

	private String mail;

	private String login;

	private String password;

	private String dateCreation;
	
	private List<CovoiturageDto> annonces = new ArrayList<CovoiturageDto>();
	
	private List<ReservationVehiculeDto> reservationsVehicule = new ArrayList<ReservationVehiculeDto>();
	
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
	public CollaborateurDto(Integer id, Integer matricule, String nom, String prenom, String dateNaissance, Integer telephone, String mail,
			String login, String password, String dateCreation, List<CovoiturageDto> annonces, List<ReservationVehiculeDto> reservationsVehicule,
			List<VehiculePersonnelDto> vehiculesPersonnel, List<RoleDto> roles, List<CovoiturageDto> covoiturages) {
		super();
		this.id=id;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
		this.mail = mail;
		this.login = login;
		this.password = password;
		this.dateCreation = dateCreation;
		this.annonces = annonces;
		this.reservationsVehicule = reservationsVehicule;
		this.vehiculesPersonnel = vehiculesPersonnel;
		this.roles = roles;
		this.covoiturages = covoiturages;
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

	/**Getter pour l'attribut matricule
	 * @return the matricule
	 */
	public Integer getMatricule() {
		return matricule;
	}

	/**Setter pour l'attribut matricule
	 * @param matricule the matricule to set
	 */
	public void setMatricule(Integer matricule) {
		this.matricule = matricule;
	}

	/**Getter pour l'attribut nom
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**Setter pour l'attribut nom
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**Getter pour l'attribut prenom
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**Setter pour l'attribut prenom
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**Getter pour l'attribut dateNaissance
	 * @return the dateNaissance
	 */
	public String getDateNaissance() {
		return dateNaissance;
	}

	/**Setter pour l'attribut dateNaissance
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**Getter pour l'attribut telephone
	 * @return the telephone
	 */
	public Integer getTelephone() {
		return telephone;
	}

	/**Setter pour l'attribut telephone
	 * @param telephone the telephone to set
	 */
	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	/**Getter pour l'attribut mail
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**Setter pour l'attribut mail
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**Getter pour l'attribut login
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**Setter pour l'attribut login
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**Getter pour l'attribut password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**Setter pour l'attribut password
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**Getter pour l'attribut dateCreation
	 * @return the dateCreation
	 */
	public String getDateCreation() {
		return dateCreation;
	}

	/**Setter pour l'attribut dateCreation
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * Getter pour l'attribut annonces
	 * @return the annonces
	 */
	public List<CovoiturageDto> getAnnonces() {
		return annonces;
	}

	/**
	 * Setter pour l'attribut annonces
	 * @param annonces the annonces to set
	 */
	public void setAnnonces(List<CovoiturageDto> annonces) {
		this.annonces = annonces;
	}

	/**
	 * Getter pour l'attribut reservationsVehicule
	 * @return the reservationsVehicule
	 */
	public List<ReservationVehiculeDto> getReservationsVehicule() {
		return reservationsVehicule;
	}

	/**
	 * Setter pour l'attribut reservationsVehicule
	 * @param reservationsVehicule the reservationsVehicule to set
	 */
	public void setReservationsVehicule(List<ReservationVehiculeDto> reservationsVehicule) {
		this.reservationsVehicule = reservationsVehicule;
	}

	/**Getter pour l'attribut vehiculesPersonnel
	 * @return the vehiculesPersonnel
	 */
	public List<VehiculePersonnelDto> getVehiculesPersonnel() {
		return vehiculesPersonnel;
	}

	/**Setter pour l'attribut vehiculesPersonnel
	 * @param vehiculesPersonnel the vehiculesPersonnel to set
	 */
	public void setVehiculesPersonnel(List<VehiculePersonnelDto> vehiculesPersonnel) {
		this.vehiculesPersonnel = vehiculesPersonnel;
	}

	/**Getter pour l'attribut roles
	 * @return the roles
	 */
	public List<RoleDto> getRoles() {
		return roles;
	}

	/**Setter pour l'attribut roles
	 * @param roles the roles to set
	 */
	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}

	/**Getter pour l'attribut covoiturages
	 * @return the covoiturages
	 */
	public List<CovoiturageDto> getCovoiturages() {
		return covoiturages;
	}

	/**Setter pour l'attribut covoiturages
	 * @param covoiturages the covoiturages to set
	 */
	public void setCovoiturages(List<CovoiturageDto> covoiturages) {
		this.covoiturages = covoiturages;
	}
	
	
}
