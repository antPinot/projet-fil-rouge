package fr.diginamic.GP3Covoiturage.dto.dtoLight;

public class RoleDtoLight {
	
	private Integer id;

	private String name;

	/**
	 * @param id
	 * @param name
	 */
	public RoleDtoLight(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * Getter pour l'attribut id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter pour l'attribut id
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter pour l'attribut name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter pour l'attribut name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
