package fr.diginamic.GP3Covoiturage.dto;

import fr.diginamic.GP3Covoiturage.enums.Categorie;
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
				vehiculeSociete.getCategorie().name(),
				ReservationVehiculeDtoMapper.listToDto(vehiculeSociete.getReservationsVehicule()));
		
		return dto;		
	}
	
	/*public static VehiculeSociete toModel(VehiculeSocieteDto vehiculeSocieteDto) {
		
		VehiculeSociete model = new VehiculeSociete(vehiculeSocieteDto.getId(),
				vehiculeSocieteDto.getImmatriculation(),
				vehiculeSocieteDto.getMarque(),
				vehiculeSocieteDto.getModele(),
				vehiculeSocieteDto.getPlaces(),
				vehiculeSocieteDto.getPhoto(),
				vehiculeSocieteDto.getDisponible(),
				vehiculeSocieteDto.getStatut(),
				Categorie.valueOfName(vehiculeSocieteDto.getCategorie()),
				ReservationVehiculeDtoMapper.listToModels(vehiculeSocieteDto.getReservationsVehicule()));
		
		return model;		
	}*/
	
}
