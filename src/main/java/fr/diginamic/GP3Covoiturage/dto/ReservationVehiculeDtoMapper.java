/**
 * 
 */
package fr.diginamic.GP3Covoiturage.dto;

import org.springframework.stereotype.Component;

import fr.diginamic.GP3Covoiturage.models.ReservationVehicule;
import fr.diginamic.GP3Covoiturage.utils.DateUtils;

/**
 * @author antPinot
 *
 */

@Component
public class ReservationVehiculeDtoMapper {
	
	public static ReservationVehiculeDto toDto(ReservationVehicule reservationVehicule) {
		ReservationVehiculeDto dto = new ReservationVehiculeDto(reservationVehicule.getId(), 
				DateUtils.localDateTimeToString(reservationVehicule.getDateDepart()), 
				DateUtils.localDateTimeToString(reservationVehicule.getDateRetour()), 
				CollaborateurDtoMapper.toDto(reservationVehicule.getCollaborateur()), 
				VehiculeSocieteDtoMapper.toDto(reservationVehicule.getVehiculeSociete()));
		
		return dto;
	}
	
	public static ReservationVehicule toModel(ReservationVehiculeDto reservationVehiculeDto) {
		ReservationVehicule model = new ReservationVehicule(reservationVehiculeDto.getId(), 
				DateUtils.stringToLocalDateTime(reservationVehiculeDto.getDateDepart()), 
				DateUtils.stringToLocalDateTime(reservationVehiculeDto.getDateRetour()), 
				CollaborateurDtoMapper.toModel(reservationVehiculeDto.getCollaborateur()), 
				VehiculeSocieteDtoMapper.toModel(reservationVehiculeDto.getVehiculeSociete()));
	}

}
