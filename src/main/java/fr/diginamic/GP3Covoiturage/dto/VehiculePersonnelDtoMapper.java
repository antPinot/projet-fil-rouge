package fr.diginamic.GP3Covoiturage.dto;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.GP3Covoiturage.models.VehiculePersonnel;

public class VehiculePersonnelDtoMapper {
	
	public static VehiculePersonnelDto toDto(VehiculePersonnel vehiculePersonnel) {
		
		VehiculePersonnelDto dto = new VehiculePersonnelDto(vehiculePersonnel.getId(),
				vehiculePersonnel.getImmatriculation(),
				vehiculePersonnel.getMarque(),
				vehiculePersonnel.getModele(),
				vehiculePersonnel.getLimitePlace(),
				vehiculePersonnel.getPlaces(),
				CovoiturageDtoMapper.listToDto(vehiculePersonnel.getCovoiturages()),
				CollaborateurDtoMapper.listToDto(vehiculePersonnel.getCollaborateurs()));
		
		return dto;
	}
	
	/*public static VehiculePersonnel toModel(VehiculePersonnelDto vehiculePersonnelDto) {
		
		VehiculePersonnel model = new VehiculePersonnel(vehiculePersonnelDto.getId(),
				vehiculePersonnelDto.getImmatriculation(),
				vehiculePersonnelDto.getMarque(),
				vehiculePersonnelDto.getModele(),
				vehiculePersonnelDto.getLimitePlace(),
				vehiculePersonnelDto.getPlaces(),
				CovoiturageDtoMapper.listToModels(vehiculePersonnelDto.getCovoiturages()),
				CollaborateurDtoMapper.listToModels(vehiculePersonnelDto.getCollaborateurs()));
		
		return model;
	}*/
	
	public static List<VehiculePersonnelDto> listToDto(List<VehiculePersonnel> vehiculePersonnel) {
		List<VehiculePersonnelDto> listVehiculePersoDto = new ArrayList<>();
		vehiculePersonnel.forEach(c -> listVehiculePersoDto.add(VehiculePersonnelDtoMapper.toDto(c)));
		return listVehiculePersoDto;
	}
	
	/*public static List<VehiculePersonnel> listToModels(List<VehiculePersonnelDto> vehiculePersonnelDto) {
		List<VehiculePersonnel> listVehiculePersoModel = new ArrayList<>();
		vehiculePersonnelDto.forEach(c -> listVehiculePersoModel.add(VehiculePersonnelDtoMapper.toModel(c)));
		return listVehiculePersoModel;
	}*/
}
