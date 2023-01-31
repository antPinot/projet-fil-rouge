package fr.diginamic.GP3Covoiturage.dto.dtoLight;

/** Classe CollaborateurDto
 * 
 * @author Quentin
 */


public class CollaborateurDtoLight {
	
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
	
	public CollaborateurDtoLight() {
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
	public CollaborateurDtoLight(Integer id, Integer matricule, String nom, String prenom, String dateNaissance, Integer telephone, String mail,
			String login, String password, String dateCreation) {
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
	
}
