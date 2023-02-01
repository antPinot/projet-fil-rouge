package fr.diginamic.GP3Covoiturage.dto.dtoEdit;

import fr.diginamic.GP3Covoiturage.dto.VehiculeSocieteDto;
import fr.diginamic.GP3Covoiturage.models.VehiculeSociete;

public class VehiculeSocieteDtoEditMapper {
	
	public static VehiculeSocieteDto toModel(VehiculeSocieteDtoEdit vehiculeSocieteDto) {
		
		VehiculeSociete vehiculeSocieteDtoEdit = new VehiculeSociete(vehiculeSocieteDto.getId(),
				vehiculeSocieteDto.getImmatriculation(),
				vehiculeSocieteDto.getMarque(),
				vehiculeSocieteDto.getModele(),
				vehiculeSocieteDto.getPlaces(),
				vehiculeSocieteDto.getPhoto(),
				vehiculeSocieteDto
				vehiculeSocieteDto.getStatut(),
				vehiculeSocieteDto.getCategorie()
				);
	}

}
