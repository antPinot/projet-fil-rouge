/**
 * 
 */
package fr.diginamic.GP3Covoiturage.dto;

import org.springframework.stereotype.Component;

import fr.diginamic.GP3Covoiturage.models.ReservationVehicule;

/**
 * @author antPinot
 *
 */

@Component
public class ReservationVehiculeDtoMapper {
	
	public static ReservationVehiculeDto toDto(ReservationVehicule reservationVehicule) {
		ReservationVehiculeDto dto = new ReservationVehiculeDto(reservationVehicule.getId(), 
				DateUtils.toString(reservationVehicule.getDateDepart()), 
				DateUtils.toString(reservationVehicule.getDateRetour()), 
				MapperCollaborateur.methodeStatic(reservationVehicule.getCollaborateur()), 
				MapperVehiculeSociete.methodeStatic(reservationVehicule.getVehiculeSociete()));
		
		return dto;
	}

}
