package fr.diginamic.GP3Covoiturage.dto.dtoLight;

import fr.diginamic.GP3Covoiturage.models.VehiculeSociete;

/**
 * @author antPinot
 *
 */
public class VehiculeSocieteDtoLightMapper {
	
	public static VehiculeSocieteDtoLight toDto (VehiculeSociete vehiculeSociete) {
		VehiculeSocieteDtoLight lightDto = new VehiculeSocieteDtoLight(vehiculeSociete.getId(), 
				vehiculeSociete.getImmatriculation(),
				vehiculeSociete.getMarque(), 
				vehiculeSociete.getModele(),
				vehiculeSociete.getPlaces(), 
				vehiculeSociete.getPhoto(), 
				vehiculeSociete.getDisponible(),
				vehiculeSociete.getStatut(),
				vehiculeSociete.getCategorie().name());
		return lightDto;
	}

}