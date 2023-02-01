package fr.diginamic.GP3Covoiturage.dto.dtoLight;

import fr.diginamic.GP3Covoiturage.models.VehiculePersonnel;

/**
 * @author Fekhreddine
 */
public class VehiculePersonnelDtolightMapper {
	
	
	public static VehiculePersonnelDtoLight toDto(VehiculePersonnel vehiculePersonnel) {
		
		VehiculePersonnelDtoLight lightDto = new VehiculePersonnelDtoLight(vehiculePersonnel.getId(),
				vehiculePersonnel.getImmatriculation(),
				vehiculePersonnel.getMarque(),
				vehiculePersonnel.getModele(),
				vehiculePersonnel.getLimitePlace(),
				vehiculePersonnel.getPlaces());
		
		
		return lightDto;
		
	}

}
