package fr.diginamic.GP3Covoiturage.dto.dtoLight;

public class AdresseDtoLight {

	/** id */
	private Integer id;

	/** numero */
	private Integer numero;

	/** complementNumero */
	private String complementNumero;

	/** voie */
	private String voie;

	/** codePostal */
	private Integer codePostal;

	/** departement */
	private String departement;

	/** pays */
	private String pays;

	/** ville */
	private String ville;

	/** constructor */
	public AdresseDtoLight(Integer id, Integer numero, String complementNumero, String voie, Integer codePostal,
			String departement, String pays, String ville) {
		super();
		this.id = id;
		this.numero = numero;
		this.complementNumero = complementNumero;
		this.voie = voie;
		this.codePostal = codePostal;
		this.departement = departement;
		this.pays = pays;
		this.ville = ville;
	}

	/** constrcutor */
	public AdresseDtoLight() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * @return the complementNumero
	 */
	public String getComplementNumero() {
		return complementNumero;
	}

	/**
	 * @param complementNumero the complementNumero to set
	 */
	public void setComplementNumero(String complementNumero) {
		this.complementNumero = complementNumero;
	}

	/**
	 * @return the voie
	 */
	public String getVoie() {
		return voie;
	}

	/**
	 * @param voie the voie to set
	 */
	public void setVoie(String voie) {
		this.voie = voie;
	}

	/**
	 * @return the codePostal
	 */
	public Integer getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the departement
	 */
	public String getDepartement() {
		return departement;
	}

	/**
	 * @param departement the departement to set
	 */
	public void setDepartement(String departement) {
		this.departement = departement;
	}

	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	
	
	
	
}
