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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Classe Collaborateur
 * 
 * @author Quentin
 */

@Entity
@Table(name = "Collaborateur")
public class Collaborateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "matricule", length = 15, nullable = false, unique = true)
	private int matricule;

	@Column(name = "nom", length = 50, nullable = false)
	private String nom;

	@Column(name = "prenom", length = 50, nullable = false)
	private String prenom;

	@Column(name = "dateNaissance", length = 50, nullable = false)
	private LocalDate dateNaissance;

	@Column(name = "telephone", length = 10, nullable = false)
	private int telephone;

	@Column(name = "mail", length = 100, nullable = false)
	private String mail;

	@Column(name = "login", length = 50, nullable = false, unique = true)
	private String login;

	@Column(name = "password", length = 50, nullable = false)
	private String password;

	@Column(name = "dateCreation", length = 50, nullable = false)
	private LocalDate dateCreation;

	@OneToMany(mappedBy = "organisateur")
	private List<Covoiturage> annonces = new ArrayList<Covoiturage>();

	@OneToMany(mappedBy = "collaborateur")
	private List<ReservationVehicule> reservationsVehicule = new ArrayList<ReservationVehicule>();

	@ManyToMany
	@JoinTable(name = "Collaborateur_VehiculePersonnel", joinColumns = @JoinColumn(name = "id_collaborateur", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_vehiculePersonnel", referencedColumnName = "id"))
	private List<VehiculePersonnel> vehiculesPersonnel = new ArrayList<VehiculePersonnel>();

	@ManyToMany
	@JoinTable(name = "Collaborateur_Role", joinColumns = @JoinColumn(name = "id_collaborateur", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "id"))
	private List<Role> roles = new ArrayList<Role>();

	@ManyToMany
	@JoinTable(name = "Participation", joinColumns = @JoinColumn(name = "Collaborateurid", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Covoiturageid", referencedColumnName = "id"))
	private List<Covoiturage> covoiturages = new ArrayList<Covoiturage>();

	public Collaborateur() {
		super();
	}

	/**
	 * Constructeur
	 * 
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
	 * @param annonces
	 * @param reservationsVehicule
	 * @param vehiculespersonnels
	 * @param roles
	 * @param covoiturages
	 */
	public Collaborateur(Integer id, int matricule, String nom, String prenom, LocalDate dateNaissance, int telephone,
			String mail, String login, String password, LocalDate dateCreation, List<Covoiturage> annonces,
			List<ReservationVehicule> reservationsVehicule, List<VehiculePersonnel> vehiculespersonnels,
			List<Role> roles, List<Covoiturage> covoiturages) {
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
		this.annonces = annonces;
		this.reservationsVehicule = reservationsVehicule;
		this.vehiculesPersonnel = vehiculespersonnels;
		this.roles = roles;
		this.covoiturages = covoiturages;
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
	public int getMatricule() {
		return matricule;
	}

	/**
	 * Setter pour l'attribut matricule
	 * 
	 * @param matricule the matricule to set
	 */
	public void setMatricule(int matricule) {
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
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * Setter pour l'attribut dateNaissance
	 * 
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * Getter pour l'attribut telephone
	 * 
	 * @return the telephone
	 */
	public int getTelephone() {
		return telephone;
	}

	/**
	 * Setter pour l'attribut telephone
	 * 
	 * @param telephone the telephone to set
	 */
	public void setTelephone(int telephone) {
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
	public LocalDate getDateCreation() {
		return dateCreation;
	}

	/**
	 * Setter pour l'attribut dateCreation
	 * 
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * Getter pour l'attribut covoiturages
	 * 
	 * @return the covoiturages
	 */
	public List<Covoiturage> getCovoiturages() {
		return covoiturages;
	}

	/**
	 * Setter pour l'attribut covoiturages
	 * 
	 * @param covoiturages the covoiturages to set
	 */
	public void setCovoiturages(List<Covoiturage> covoiturages) {
		this.covoiturages = covoiturages;
	}

	/**
	 * Getter pour l'attribut reservationsVehicule
	 * 
	 * @return the reservationsVehicule
	 */
	public List<ReservationVehicule> getReservationsVehicule() {
		return reservationsVehicule;
	}

	/**
	 * Setter pour l'attribut reservationsVehicule
	 * 
	 * @param reservationsVehicule the reservationsVehicule to set
	 */
	public void setReservationsVehicule(List<ReservationVehicule> reservationsVehicule) {
		this.reservationsVehicule = reservationsVehicule;
	}

	/**
	 * Getter pour l'attribut vehiculespersonnels
	 * 
	 * @return the vehiculespersonnels
	 */
	public List<VehiculePersonnel> getVehiculespersonnels() {
		return vehiculesPersonnel;
	}

	/**
	 * Setter pour l'attribut vehiculespersonnels
	 * 
	 * @param vehiculespersonnels the vehiculespersonnels to set
	 */
	public void setVehiculespersonnels(List<VehiculePersonnel> vehiculespersonnels) {
		this.vehiculesPersonnel = vehiculespersonnels;
	}

	/**
	 * Getter pour l'attribut roles
	 * 
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * Setter pour l'attribut roles
	 * 
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 * Getter pour l'attribut annonces
	 * 
	 * @return the annonces
	 */
	public List<Covoiturage> getAnnonces() {
		return annonces;
	}

	/**
	 * Setter pour l'attribut annonces
	 * 
	 * @param annonces the annonces to set
	 */
	public void setAnnonces(List<Covoiturage> annonces) {
		this.annonces = annonces;
	}

}
