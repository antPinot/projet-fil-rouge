package fr.diginamic.GP3Covoiturage.dto;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.models.VehiculePersonnel;

public class VehiculePersonnelDtoMapper {
	
	public static VehiculePersonnelDto toDto(VehiculePersonnel vehiculePersonnel) {
		
		VehiculePersonnelDto dto = new VehiculePersonnelDto(vehiculePersonnel.getId(),
				vehiculePersonnel.getImmatriculation(),
				vehiculePersonnel.getMarque(),
				vehiculePersonnel.getModele(),
				vehiculePersonnel.getLimitePlace(),
				CollaborateurDtoMapper.toDto(vehiculePersonnel.getCollaborateurs()));
		
		return dto;
	}
	
	public static List<VehiculePersonnelDto> listToDto(List<VehiculePersonnel> vehiculePersonnel) {
		List<VehiculePersonnelDto> listVehiculePersoDto = new ArrayList<>();
		vehiculePersonnel.forEach(c -> listVehiculePersoDto.add(VehiculePersonnelDtoMapper.toDto(c)));
		return listVehiculePersoDto;
	}
}
