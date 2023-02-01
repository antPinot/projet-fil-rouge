/**
 * 
 */
package fr.diginamic.GP3Covoiturage.dto.dtoEdit;

import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.models.ReservationVehicule;
import fr.diginamic.GP3Covoiturage.models.VehiculeSociete;
import fr.diginamic.GP3Covoiturage.utils.DateUtils;

/**
 * @author antPinot
 *
 */
public class ReservationVehiculeEditDtoMapper {
	
	public static ReservationVehicule toModel(ReservationVehiculeEditDto reservationVehiculeEditDto) {
		Collaborateur collab = new Collaborateur();
		collab.setId(reservationVehiculeEditDto.getCollaborateurId());
		VehiculeSociete vehicule = new VehiculeSociete();
		vehicule.setId(reservationVehiculeEditDto.getVehiculeSocieteId());
		ReservationVehicule model = new ReservationVehicule(reservationVehiculeEditDto.getId(),
				DateUtils.stringToLocalDateTime(reservationVehiculeEditDto.getDateDepart()) ,
				DateUtils.stringToLocalDateTime(reservationVehiculeEditDto.getDateRetour()), 
				collab, vehicule);
		
		return model;
	}

}
