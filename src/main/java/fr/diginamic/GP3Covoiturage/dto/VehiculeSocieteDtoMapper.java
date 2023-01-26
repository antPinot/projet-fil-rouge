package fr.diginamic.GP3Covoiturage.dto;

import fr.diginamic.GP3Covoiturage.models.VehiculeSociete;

public class VehiculeSocieteDtoMapper {
	
	public static VehiculeSocieteDto toDto(VehiculeSociete vehiculeSociete) {
		
		VehiculeSocieteDto dto = new VehiculeSocieteDto(vehiculeSociete.getId(),
				vehiculeSociete.getImmatriculation(),
				vehiculeSociete.getMarque(),
				vehiculeSociete.getModele(),
				vehiculeSociete.getPlaces(),
				vehiculeSociete.getPhoto(),
				vehiculeSociete.getDisponible(),
				vehiculeSociete.getStatut(),
				vehiculeSociete.getCategorie());
		
		return dto;		
	}

}
