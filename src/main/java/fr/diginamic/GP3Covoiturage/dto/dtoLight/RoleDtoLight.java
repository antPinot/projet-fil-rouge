package fr.diginamic.GP3Covoiturage.dto.dtoLight;


/**
 * @author Fekhreddine
 */
public class RoleDtoLight {
	
	/**
	 * les entites de la classe
	 */

	private Integer id;

	private String name;
	
	
	

	/**
	 * @constructor full
	 */
	public RoleDtoLight(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	/**
	 * @constructor empty
	 */
	public RoleDtoLight() {}

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	

}
