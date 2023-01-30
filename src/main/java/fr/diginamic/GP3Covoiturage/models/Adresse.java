/**
 * 
 */
package fr.diginamic.GP3Covoiturage.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * @author antPinot
 * 
 * Modèle de l'entité Adresse qui représente 
 * une adrese de départ ou d'arrivée du covoiturage
 *
 */

@Entity
@Table(name = "adresse")
public class Adresse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "numero")
	@Max(999999)
	private Integer numero;
	
	@Column(columnDefinition = "varchar(3)", name = "complement_numero", length = 3)
	@Size(max = 3)
	private String complementNumero;
	
	@Column(columnDefinition = "varchar(255)", name = "voie", length = 255, nullable = false)
	@NotBlank
	@Size(max = 255)
	private String voie;
	
	@Column(name = "code_postal", nullable = false)
	@Max(99999)
	private Integer codePostal;
	
	@Column(columnDefinition = "varchar(100)", name = "departement", nullable = false)
	@NotBlank
	@Size(max = 100)
	private String departement;
	
	@Column(columnDefinition = "varchar(50)",name = "pays", nullable = false)
	@NotBlank
	@Size(max = 50)
	private String pays;
	
	@Column(columnDefinition = "varchar(58)",name = "ville", nullable = false)
	@NotBlank
	@Size(max = 58)
	private String ville;
	
	@OneToMany(mappedBy = "adresseDepart")
	List<Covoiturage> covoiturageDepart = new ArrayList<>();
	
	@OneToMany(mappedBy = "adresseArrivee")
	List<Covoiturage> covoiturageArrivee = new ArrayList<>();
	
	/**
	 * Constructeur vide pour JPA
	 *
	 */
	public Adresse() {
		
	}

	/**Constructeur
	 * @param id
	 * @param numero
	 * @param complementNumero
	 * @param voie
	 * @param codePostal
	 * @param departement
	 * @param pays
	 * @param ville
	 * @param covoiturageDepart
	 * @param covoiturageArrivee
	 */
	public Adresse(Integer id, @Size(max = 5) Integer numero, @Size(max = 3) String complementNumero,
			@NotBlank @Size(max = 255) String voie, @NotNull @Size(max = 6) Integer codePostal,
			@NotBlank @Size(max = 100) String departement, @NotBlank @Size(max = 50) String pays,
			@NotBlank @Size(max = 58) String ville, List<Covoiturage> covoiturageDepart,
			List<Covoiturage> covoiturageArrivee) {
		this.id = id;
		this.numero = numero;
		this.complementNumero = complementNumero;
		this.voie = voie;
		this.codePostal = codePostal;
		this.departement = departement;
		this.pays = pays;
		this.ville = ville;
		this.covoiturageDepart = covoiturageDepart;
		this.covoiturageArrivee = covoiturageArrivee;
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

	/**Getter pour l'attribut numero
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**Setter pour l'attribut numero
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**Getter pour l'attribut complementNumero
	 * @return the complementNumero
	 */
	public String getComplementNumero() {
		return complementNumero;
	}

	/**Setter pour l'attribut complementNumero
	 * @param complementNumero the complementNumero to set
	 */
	public void setComplementNumero(String complementNumero) {
		this.complementNumero = complementNumero;
	}

	/**Getter pour l'attribut voie
	 * @return the voie
	 */
	public String getVoie() {
		return voie;
	}

	/**Setter pour l'attribut voie
	 * @param voie the voie to set
	 */
	public void setVoie(String voie) {
		this.voie = voie;
	}

	/**Getter pour l'attribut codePostal
	 * @return the codePostal
	 */
	public Integer getCodePostal() {
		return codePostal;
	}

	/**Setter pour l'attribut codePostal
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	/**Getter pour l'attribut departement
	 * @return the departement
	 */
	public String getDepartement() {
		return departement;
	}

	/**Setter pour l'attribut departement
	 * @param departement the departement to set
	 */
	public void setDepartement(String departement) {
		this.departement = departement;
	}

	/**Getter pour l'attribut pays
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}

	/**Setter pour l'attribut pays
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**Getter pour l'attribut ville
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**Setter pour l'attribut ville
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**Getter pour l'attribut covoiturageDepart
	 * @return the covoiturageDepart
	 */
	public List<Covoiturage> getCovoiturageDepart() {
		return covoiturageDepart;
	}

	/**Setter pour l'attribut covoiturageDepart
	 * @param covoiturageDepart the covoiturageDepart to set
	 */
	public void setCovoiturageDepart(List<Covoiturage> covoiturageDepart) {
		this.covoiturageDepart = covoiturageDepart;
	}

	/**Getter pour l'attribut covoiturageArrivee
	 * @return the covoiturageArrivee
	 */
	public List<Covoiturage> getCovoiturageArrivee() {
		return covoiturageArrivee;
	}

	/**Setter pour l'attribut covoiturageArrivee
	 * @param covoiturageArrivee the covoiturageArrivee to set
	 */
	public void setCovoiturageArrivee(List<Covoiturage> covoiturageArrivee) {
		this.covoiturageArrivee = covoiturageArrivee;
	}
	
	

}
