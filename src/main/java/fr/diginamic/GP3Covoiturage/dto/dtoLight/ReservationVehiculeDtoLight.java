package fr.diginamic.GP3Covoiturage.dto.dtoLight;

/**
 * DTO pour sauvegarder ou créer une réservation
 * 
 * @author Fekhreddine
 *
 */
public class ReservationVehiculeDtoLight {

	private Integer id;

	private String dateDepart;

	private String dateRetour;

	private CollaborateurDtoLight collaborateur;

	private VehiculeSocieteDtoLight vehiculeSociete;

	/**
	 * 
	 * @construct
	 */
	public ReservationVehiculeDtoLight(Integer id, String dateDepart, String dateRetour, CollaborateurDtoLight collaborateur,
			VehiculeSocieteDtoLight vehiculeSociete) {
		super();
		this.id = id;
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.collaborateur = collaborateur;
		this.vehiculeSociete = vehiculeSociete;
	}

	public ReservationVehiculeDtoLight() {
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
	 * @return the dateDepart
	 */
	public String getDateDepart() {
		return dateDepart;
	}

	/**
	 * @param dateDepart the dateDepart to set
	 */
	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	/**
	 * @return the dateRetour
	 */
	public String getDateRetour() {
		return dateRetour;
	}

	/**
	 * @param dateRetour the dateRetour to set
	 */
	public void setDateRetour(String dateRetour) {
		this.dateRetour = dateRetour;
	}

	/**
	 * @return the collaborateur
	 */
	public CollaborateurDtoLight getCollaborateur() {
		return collaborateur;
	}

	/**
	 * @param collaborateur the collaborateur to set
	 */
	public void setCollaborateur(CollaborateurDtoLight collaborateur) {
		this.collaborateur = collaborateur;
	}

	/**
	 * @return the vehiculeSociete
	 */
	public VehiculeSocieteDtoLight getVehiculeSociete() {
		return vehiculeSociete;
	}

	/**
	 * @param vehiculeSociete the vehiculeSociete to set
	 */
	public void setVehiculeSociete(VehiculeSocieteDtoLight vehiculeSociete) {
		this.vehiculeSociete = vehiculeSociete;
	}

	

}
