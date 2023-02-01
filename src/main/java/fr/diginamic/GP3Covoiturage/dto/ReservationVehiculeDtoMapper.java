/**
 * 
 */
package fr.diginamic.GP3Covoiturage.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import fr.diginamic.GP3Covoiturage.dto.dtoLight.CollaborateurDtoLightMapper;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.VehiculeSocieteDtoLightMapper;
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
				CollaborateurDtoLightMapper.toDto(reservationVehicule.getCollaborateur()), 
				VehiculeSocieteDtoLightMapper.toDto(reservationVehicule.getVehiculeSociete()));
		
		return dto;
	}
	
	/*public static ReservationVehicule toModel(ReservationVehiculeDto reservationVehiculeDto) {
		ReservationVehicule model = new ReservationVehicule(reservationVehiculeDto.getId(), 
				DateUtils.stringToLocalDateTime(reservationVehiculeDto.getDateDepart()), 
				DateUtils.stringToLocalDateTime(reservationVehiculeDto.getDateRetour()), 
				CollaborateurDtoLightMapper.toModel(reservationVehiculeDto.getCollaborateur()), 
				VehiculeSocieteDtoMapper.toModel(reservationVehiculeDto.getVehiculeSociete()));
		
		return model;
	}*/
	
	/*public static ReservationVehiculeDto methodeTest(ReservationVehicule reservationVehicule) {
		ReservationVehiculeDto dto = new ReservationVehiculeDto();
		dto.setId(reservationVehicule.getId());
		dto.setDateDepart(DateUtils.localDateTimeToString(reservationVehicule.getDateDepart()));
		dto.setDateRetour(DateUtils.localDateTimeToString(reservationVehicule.getDateRetour()));
		
		return dto;
	}*/
	
	public static List<ReservationVehiculeDto> listToDto(List<ReservationVehicule> reservations){
		List<ReservationVehiculeDto> listDto = new ArrayList<>();
		reservations.forEach(r -> listDto.add(ReservationVehiculeDtoMapper.toDto(r)));
		return listDto;
	}
	
	/*public static List<ReservationVehicule> listToModels(List<ReservationVehiculeDto> reservationsDto){
		List<ReservationVehicule> listModel = new ArrayList<>();
		reservationsDto.forEach(r -> listModel.add(ReservationVehiculeDtoMapper.toModel(r)));
		return listModel;
	}*/

}
