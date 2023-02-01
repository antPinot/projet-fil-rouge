package fr.diginamic.GP3Covoiturage.dto.dtoLight;

import fr.diginamic.GP3Covoiturage.models.VehiculePersonnel;

/**
 * Classe Collaborateur
 * 
 * @author Quentin
 */

public class VehiculePersonnelDtoLightMapper {
	
	public static VehiculePersonnelDtoLight toDto (VehiculePersonnel vehiculePersonnel) {
		VehiculePersonnelDtoLight lightDto = new VehiculePersonnelDtoLight(vehiculePersonnel.getId(), 
				vehiculePersonnel.getImmatriculation(),
				vehiculePersonnel.getMarque(), 
				vehiculePersonnel.getModele(),
				vehiculePersonnel.getPlaces(), 
				vehiculePersonnel.getLimitePlace());
		return lightDto;
	}

}
