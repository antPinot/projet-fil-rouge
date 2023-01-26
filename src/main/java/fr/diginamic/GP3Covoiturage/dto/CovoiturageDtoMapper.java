package fr.diginamic.GP3Covoiturage.dto;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.GP3Covoiturage.models.Covoiturage;
import fr.diginamic.GP3Covoiturage.utils.DateUtils;

/**
 * @author Fekhreddine
 */
public class CovoiturageDtoMapper {

	public static CovoiturageDto toDto(Covoiturage covoiturage) {

		CovoiturageDto dto = new CovoiturageDto(covoiturage.getId(), DateUtils.localDateTimeToString(covoiturage.getDateDepart()),
				covoiturage.getPlacesRestantes(), covoiturage.getNbPersonnes(), covoiturage.getDureeTrajet(),
				covoiturage.getDistance(), CollaborateurDtoMapper.toDto(covoiturage.getOrganisateur()),
				VehiculePersonnelDtoMapper.toDto(covoiturage.getVehiculePersonnel()),
				AdresseDtoMapper.toDto(covoiturage.getAdresseDepart()),
				AdresseDtoMapper.toDto(covoiturage.getAdresseArrivee()),
				CollaborateurDtoMapper.listToDto(covoiturage.getCollaborateurs()));

		return dto;

	}

	/**
	 * methode qui retourne une liste de collaborateurs
	 */

	public static List<CovoiturageDto> listToDto(List<Covoiturage> covoiturages) {

		List<CovoiturageDto> listCovoiDto = new ArrayList<>();

		covoiturages.forEach(c -> listCovoiDto.add(CovoiturageDtoMapper.toDto(c)));

		return listCovoiDto;
	}

}
