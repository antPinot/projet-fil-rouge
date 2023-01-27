package fr.diginamic.GP3Covoiturage.models;

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
import jakarta.persistence.Table;

/**
 * @author Fekhreddine
 */

@Entity
@Table(name = "Role")
public class Role {

	/**
	 * les entites de la classe
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	

	@Column(length = 50)
	private String name;

	/**
	 * relation many to many avec collaborateur
	 */
	@ManyToMany
	@JoinTable(name = "Collaborateur_Role", joinColumns = @JoinColumn(name = "RoleName", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Collaborateurid", referencedColumnName = "id"))

	List<Collaborateur> collaborateurs = new ArrayList<>();

	/**
	 * @return constructor avec les entites
	 */
	public Role(Integer id, String name, List<Collaborateur> collaborateurs) {
		super();
		this.id = id;
		this.name = name;
		this.collaborateurs = collaborateurs;
	}


	/**
	 * @return constructor vide
	 */
	public Role() {
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
	
	
	/**
	 * @return the collaborateurs
	 */
	public List<Collaborateur> getCollaborateurs() {
		return collaborateurs;
	}

	/**
	 * @param collaborateurs the collaborateurs to set
	 */
	public void setCollaborateurs(List<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

	/**
	 * 
	 * 
	 *
	 * methode toString
	 */

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

}
