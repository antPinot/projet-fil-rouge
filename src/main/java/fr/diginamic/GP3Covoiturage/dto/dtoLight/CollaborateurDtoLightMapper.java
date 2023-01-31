package fr.diginamic.GP3Covoiturage.dto.dtoLight;

import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.utils.DateUtils;

public class CollaborateurDtoLightMapper {
	
	
	public static CollaborateurDtoLight toDto(Collaborateur collaborateur) {
		CollaborateurDtoLight lightDto = new CollaborateurDtoLight(collaborateur.getId(), collaborateur.getMatricule(),
				collaborateur.getNom(), collaborateur.getPrenom(),
				DateUtils.localDateToString(collaborateur.getDateNaissance()), collaborateur.getTelephone(),
				collaborateur.getMail(), collaborateur.getLogin(), collaborateur.getPassword(),
				DateUtils.localDateToString(collaborateur.getDateCreation()));
		return lightDto;
	}


}
