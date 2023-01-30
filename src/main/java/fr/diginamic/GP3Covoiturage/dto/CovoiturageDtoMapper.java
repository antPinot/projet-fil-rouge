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

		CovoiturageDto dto = new CovoiturageDto(covoiturage.getId(),
				DateUtils.localDateTimeToString(covoiturage.getDateDepart()), covoiturage.getPlacesRestantes(),
				covoiturage.getNbPersonnes(), covoiturage.getDureeTrajet(), covoiturage.getDistance(),
				CollaborateurDtoMapper.toDto(covoiturage.getOrganisateur()),
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

	/**
	 * methode qui retourne une liste de modele
	 */
	public static List<Covoiturage> listToModels(List<CovoiturageDto> covoituragesDto) {

		List<Covoiturage> listCovoiModels = new ArrayList<>();

		covoituragesDto.forEach(c -> listCovoiModels.add(CovoiturageDtoMapper.toModel(c)));

		return listCovoiModels;
	}

	/**
	 * methode qui retourne un modele
	 */
	public static Covoiturage toModel(CovoiturageDto c) {

		Covoiturage modelCovoit = new Covoiturage(c.getId(), DateUtils.stringToLocalDateTime(c.getDateDepart()),
				c.getPlacesRestantes(), c.getNbPersonnes(), c.getDureeTrajet(), c.getDistance(),
				CollaborateurDtoMapper.toModel(c.getOrganisateur()),
				VehiculePersonnelDtoMapper.toModel(c.getVehiculePersonnel()),
				AdresseDtoMapper.toModel(c.getAdresseDepart()), 
				AdresseDtoMapper.toModel(c.getAdresseArrivee()),
				CollaborateurDtoMapper.listToModels(c.getCollaborateurs()));

		return modelCovoit;
	}

}
