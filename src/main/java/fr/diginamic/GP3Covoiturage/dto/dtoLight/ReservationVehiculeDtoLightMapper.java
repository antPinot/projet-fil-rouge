package fr.diginamic.GP3Covoiturage.dto.dtoLight;

import org.hibernate.query.NativeQuery.ReturnableResultNode;

import fr.diginamic.GP3Covoiturage.models.ReservationVehicule;
import fr.diginamic.GP3Covoiturage.utils.DateUtils;

/**
 * @author Fekhreddine
 *
 */
public class ReservationVehiculeDtoLightMapper {

	public static ReservationVehiculeDtoLight toDto(ReservationVehicule reservationVehicule) {

		ReservationVehiculeDtoLight lightDto = new ReservationVehiculeDtoLight(reservationVehicule.getId(),
				DateUtils.localDateTimeToString(reservationVehicule.getDateDepart()),
				DateUtils.localDateTimeToString(reservationVehicule.getDateRetour()),
				CollaborateurDtoLightMapper.toDto(reservationVehicule.getCollaborateur()),
				VehiculeSocieteDtoLightMapper.toDto(reservationVehicule.getVehiculeSociete()));

		return lightDto;
	}

}
