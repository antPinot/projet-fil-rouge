package fr.diginamic.GP3Covoiturage.dto.dtoLight;

import fr.diginamic.GP3Covoiturage.models.Covoiturage;

/**
 * @author Fekhreddine
 */
public class CovoiturageDtoLightMapper {
	
	public static CovoiturageLightDto toDto(Covoiturage covoiturage) {
		
		CovoiturageLightDto dto = new CovoiturageLightDto(covoiturage.getId(), 
				covoiturage., 
				null,
				null, 
				null, 
				null, 
				null, null, null, null);
		
	}

}
