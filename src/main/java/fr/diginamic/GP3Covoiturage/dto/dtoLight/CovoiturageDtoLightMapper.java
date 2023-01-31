package fr.diginamic.GP3Covoiturage.dto.dtoLight;

import fr.diginamic.GP3Covoiturage.models.Covoiturage;
import fr.diginamic.GP3Covoiturage.utils.DateUtils;

/**
 * @author Fekhreddine
 */
public class CovoiturageDtoLightMapper {

	public static CovoiturageDtoLight toDto(Covoiturage covoiturage) {

		CovoiturageDtoLight lightDto = new CovoiturageDtoLight(covoiturage.getId(),
				DateUtils.localDateTimeToString(covoiturage.getDateDepart()), covoiturage.getPlacesRestantes(),
				covoiturage.getNbPersonnes(), covoiturage.getDureeTrajet(), covoiturage.getDistance(),
				CollaborateurDtoLightMapper.toDto(covoiturage.getOrganisateur()),
				VehiculePersonnelDtolightMapper.toDto(covoiturage.getVehiculePersonnel()),
				AdresseDtoLightMapper.toDto(covoiturage.getAdresseArrivee()),
				AdresseDtoLightMapper.toDto(covoiturage.getAdresseDepart()));

		return lightDto;

	}

}
