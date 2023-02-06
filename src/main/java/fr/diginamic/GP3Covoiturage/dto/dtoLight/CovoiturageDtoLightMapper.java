package fr.diginamic.GP3Covoiturage.dto.dtoLight;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.GP3Covoiturage.models.Covoiturage;
import fr.diginamic.GP3Covoiturage.utils.DateUtils;

/**
 * @author Fekhreddine
 */
public class CovoiturageDtoLightMapper {

	public static CovoiturageDtoLight toDto(Covoiturage covoiturage) {

		List<CollaborateurDtoLight> collaborateursDto = new ArrayList<>();

		covoiturage.getCollaborateurs().forEach(c -> collaborateursDto.add(CollaborateurDtoLightMapper.toDto(c)));

		CovoiturageDtoLight lightDto = new CovoiturageDtoLight(covoiturage.getId(),
				DateUtils.localDateTimeToString(covoiturage.getDateDepart()), covoiturage.getPlacesRestantes(),
				covoiturage.getNbPersonnes(), covoiturage.getDureeTrajet(), covoiturage.getDistance(),
				CollaborateurDtoLightMapper.toDto(covoiturage.getOrganisateur()),
				VehiculePersonnelDtoLightMapper.toDto(covoiturage.getVehiculePersonnel()),
				AdresseDtoLightMapper.toDto(covoiturage.getAdresseArrivee()),
				AdresseDtoLightMapper.toDto(covoiturage.getAdresseDepart()),
				collaborateursDto);

		return lightDto;

	}

}
