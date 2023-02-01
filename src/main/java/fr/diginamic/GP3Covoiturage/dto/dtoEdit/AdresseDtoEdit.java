/**
 * 
 */
package fr.diginamic.GP3Covoiturage.dto.dtoEdit;

/**
 * @author antPinot
 *
 */
public class AdresseDtoEdit {

	private Integer id;

	private Integer numero;

	private String complementNumero;

	private String voie;

	private Integer codePostal;

	private String departement;

	private String pays;

	private String ville;

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param numero
	 * @param complementNumero
	 * @param voie
	 * @param codePostal
	 * @param departement
	 * @param pays
	 * @param ville
	 */
	public AdresseDtoEdit(Integer id, Integer numero, String complementNumero, String voie, Integer codePostal,
			String departement, String pays, String ville) {
		this.id = id;
		this.numero = numero;
		this.complementNumero = complementNumero;
		this.voie = voie;
		this.codePostal = codePostal;
		this.departement = departement;
		this.pays = pays;
		this.ville = ville;
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
	 * Getter pour l'attribut numero
	 * 
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * Setter pour l'attribut numero
	 * 
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * Getter pour l'attribut complementNumero
	 * 
	 * @return the complementNumero
	 */
	public String getComplementNumero() {
		return complementNumero;
	}

	/**
	 * Setter pour l'attribut complementNumero
	 * 
	 * @param complementNumero the complementNumero to set
	 */
	public void setComplementNumero(String complementNumero) {
		this.complementNumero = complementNumero;
	}

	/**
	 * Getter pour l'attribut voie
	 * 
	 * @return the voie
	 */
	public String getVoie() {
		return voie;
	}

	/**
	 * Setter pour l'attribut voie
	 * 
	 * @param voie the voie to set
	 */
	public void setVoie(String voie) {
		this.voie = voie;
	}

	/**
	 * Getter pour l'attribut codePostal
	 * 
	 * @return the codePostal
	 */
	public Integer getCodePostal() {
		return codePostal;
	}

	/**
	 * Setter pour l'attribut codePostal
	 * 
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Getter pour l'attribut departement
	 * 
	 * @return the departement
	 */
	public String getDepartement() {
		return departement;
	}

	/**
	 * Setter pour l'attribut departement
	 * 
	 * @param departement the departement to set
	 */
	public void setDepartement(String departement) {
		this.departement = departement;
	}

	/**
	 * Getter pour l'attribut pays
	 * 
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * Setter pour l'attribut pays
	 * 
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * Getter pour l'attribut ville
	 * 
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Setter pour l'attribut ville
	 * 
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

}
