package fr.diginamic.GP3Covoiturage.dto;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.utils.DateUtils;

public class CollaborateurDtoMapper {

	public static CollaborateurDto toDto(Collaborateur collaborateur) {

		CollaborateurDto dto = new CollaborateurDto(collaborateur.getId(), collaborateur.getMatricule(),
				collaborateur.getNom(), collaborateur.getPrenom(),
				DateUtils.localDateToString(collaborateur.getDateNaissance()), collaborateur.getTelephone(),
				collaborateur.getMail(), collaborateur.getLogin(), collaborateur.getPassword(),
				DateUtils.localDateToString(collaborateur.getDateCreation()),
				CovoiturageDtoMapper.listToDto(collaborateur.getAnnonces()),
				ReservationVehiculeDtoMapper.listToDto(collaborateur.getReservationsVehicule()),
				VehiculePersonnelDtoMapper.listToDto(collaborateur.getVehiculespersonnels()),
				RoleDtoMapper.listToDto(collaborateur.getRoles()),
				CovoiturageDtoMapper.listToDto(collaborateur.getCovoiturages()));

		return dto;
	}

	/*public static Collaborateur toModel(CollaborateurDto collaborateurDto) {

		Collaborateur model = new Collaborateur(collaborateurDto.getId(), collaborateurDto.getMatricule(),
				collaborateurDto.getNom(), collaborateurDto.getPrenom(),
				DateUtils.stringToLocalDate(collaborateurDto.getDateNaissance()), collaborateurDto.getTelephone(),
				collaborateurDto.getMail(), collaborateurDto.getLogin(), collaborateurDto.getPassword(),
				DateUtils.stringToLocalDate(collaborateurDto.getDateCreation()),
				CovoiturageDtoMapper.listToModels(collaborateurDto.getAnnonces()),
				ReservationVehiculeDtoMapper.listToModels(collaborateurDto.getReservationsVehicule()),
				VehiculePersonnelDtoMapper.listToModels(collaborateurDto.getVehiculesPersonnel()),
				RoleDtoMapper.listToModels(collaborateurDto.getRoles()),
				CovoiturageDtoMapper.listToModels(collaborateurDto.getCovoiturages()));

		return model;
	}*/

	/**
	 * methode renvoi une list
	 */
	public static List<CollaborateurDto> listToDto(List<Collaborateur> collaborateurs) {
		List<CollaborateurDto> listCollabDto = new ArrayList<>();
		collaborateurs.forEach(c -> listCollabDto.add(CollaborateurDtoMapper.toDto(c)));
		return listCollabDto;
	}

	/*public static List<Collaborateur> listToModels(List<CollaborateurDto> collaborateursDto) {
		List<Collaborateur> listCollabModel = new ArrayList<>();
		collaborateursDto.forEach(c -> listCollabModel.add(CollaborateurDtoMapper.toModel(c)));
		return listCollabModel;
	}*/

}
