package fr.diginamic.GP3Covoiturage.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.type.descriptor.DateTimeUtils;

import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.models.Covoiturage;

/**
 * @author Fekhreddine
 */
public class CovoiturageDtoMapper {

	public static  CovoiturageDto toDto(Covoiturage covoiturage) {
		
		CovoiturageDto dto = new CovoiturageDto(covoiturage.getId(),
				DateUtils.toString(covoiturage.getDateDepart())),
				covoiturage.getPlacesRestantes(),
				covoiturage.getNbPersonnes(),
				covoiturage.getDureeTrajet(),
				covoiturage.getDistance(),
				CollaborateurDtoMapper.toDto(covoiturage.getOrganisateur()),
				VehiculePersonnelDtoMapper.toDto(covoiturage.getVehiculePersonnel()),
				AdresseDtoMapper.toDto(covoiturage.getAdresseDepart()),
				AdresseDtoMapper.toDto(covoiturage.getAdresseArrivee()),
				CollaborateurDtoMapper.toDto(covoiturage.getCollaborateurs());
		
		return dto;
		
	}

	/**
	 * methode qui retourne une liste de collaborateurs
	 */

	public static List<CollaborateurDto> listToDtoCollaborateur(List<Collaborateur> collaborateurs) {

		List<CollaborateurDto> listCollabDto = new ArrayList<>();

		collaborateurs.forEach(c -> listCollabDto.add(CollaborateurDtoMapper.toDto(c)));

		return listCollabDto;
	}
	
	
	 

}
