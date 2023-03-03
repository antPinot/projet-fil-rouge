package fr.diginamic.GP3Covoiturage.dto.dtoEdit;

import java.util.List;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Classe CollaborateurDto
 * 
 * @author Quentin
 */

public class CollaborateurDtoEdit {

	private Integer id;

	private Integer matricule;

	@Size(max = 50, message = "Votre nom doit être inférieur à 50 caractères")
	private String nom;
	
	@Size(max = 50, message = "Votre prénom doit être inférieur à 50 caractères")
	private String prenom;

	private String dateNaissance;

	private Integer telephone;

	@Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Email invalide")
	private String mail;

	private String login;

	private String password;

	private String dateCreation;
	
	private List<Integer> rolesId;

	/**
	 * @param id
	 * @param matricule
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param telephone
	 * @param mail
	 * @param login
	 * @param password
	 * @param dateCreation
	 */
	public CollaborateurDtoEdit(Integer id, Integer matricule, String nom, String prenom, String dateNaissance,
			Integer telephone, String mail, String login, String password, String dateCreation, List<Integer> rolesId) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
		this.mail = mail;
		this.login = login;
		this.password = password;
		this.dateCreation = dateCreation;
		this.rolesId = rolesId;
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
	 * Getter pour l'attribut matricule
	 * 
	 * @return the matricule
	 */
	public Integer getMatricule() {
		return matricule;
	}

	/**
	 * Setter pour l'attribut matricule
	 * 
	 * @param matricule the matricule to set
	 */
	public void setMatricule(Integer matricule) {
		this.matricule = matricule;
	}

	/**
	 * Getter pour l'attribut nom
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter pour l'attribut nom
	 * 
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter pour l'attribut prenom
	 * 
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter pour l'attribut prenom
	 * 
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter pour l'attribut dateNaissance
	 * 
	 * @return the dateNaissance
	 */
	public String getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * Setter pour l'attribut dateNaissance
	 * 
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * Getter pour l'attribut telephone
	 * 
	 * @return the telephone
	 */
	public Integer getTelephone() {
		return telephone;
	}

	/**
	 * Setter pour l'attribut telephone
	 * 
	 * @param telephone the telephone to set
	 */
	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	/**
	 * Getter pour l'attribut mail
	 * 
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Setter pour l'attribut mail
	 * 
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Getter pour l'attribut login
	 * 
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Setter pour l'attribut login
	 * 
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Getter pour l'attribut password
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter pour l'attribut password
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter pour l'attribut dateCreation
	 * 
	 * @return the dateCreation
	 */
	public String getDateCreation() {
		return dateCreation;
	}

	/**
	 * Setter pour l'attribut dateCreation
	 * 
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<Integer> getRolesId() {
		return rolesId;
	}

	public void setRolesId(List<Integer> rolesId) {
		this.rolesId = rolesId;
	}

}
