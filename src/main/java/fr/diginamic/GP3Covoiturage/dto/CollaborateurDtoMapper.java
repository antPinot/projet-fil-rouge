package fr.diginamic.GP3Covoiturage.dto;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.GP3Covoiturage.models.Collaborateur;

public class CollaborateurDtoMapper {
	
	public static CollaborateurDto toDto(Collaborateur collaborateur) {
		
		CollaborateurDto dto = new CollaborateurDto(collaborateur.getId(),
				collaborateur.getMatricule(),
				collaborateur.getNom(),
				collaborateur.getPrenom(),
				DateUtils.toString(collaborateur.getDateNaissance()),
				collaborateur.getTelephone(),
				collaborateur.getMail(),
				collaborateur.getLogin(),
				collaborateur.getPassword(),
				DateUtils.toString(collaborateur.getDateCreation()),
				VehiculePersonnelDtoMapper.listToDto(collaborateur.getVehiculespersonnels()),
				RoleDtoMapper.listToDto(collaborateur.getRoles()),
				CovoiturageDtoMapper.listToDto(collaborateur.getCovoiturages()));
		
		return dto;
	}
	
	
	/**
	 * methode renvoi une list
	 */
	public static List<CollaborateurDto> listToDto(List<Collaborateur> collaborateurs) {
		List<CollaborateurDto> listCollabDto = new ArrayList<>();
		collaborateurs.forEach(c -> listCollabDto.add(CollaborateurDtoMapper.toDto(c)));
		return listCollabDto;
	}

}
