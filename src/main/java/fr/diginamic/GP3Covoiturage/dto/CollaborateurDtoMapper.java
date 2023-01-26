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
				VehiculePersonnelDtoMapper.toDto(collaborateur.getVehiculespersonnels()),
				RoleDtoMapper.toDto(collaborateur.getRoles()),
				CovoiturageDtoMapper.toDto(collaborateur.getCovoiturages()));
		
		return dto;
	}
	
	public static List<CollaborateurDto> listToDto(List<Collaborateur> collaborateurs) {
		List<CollaborateurDto> listCollabDto = new ArrayList<>();
		collaborateurs.forEach(c -> listCollabDto.add(CollaborateurDtoMapper.toDto(c)));
		return listCollabDto;
	}

}
