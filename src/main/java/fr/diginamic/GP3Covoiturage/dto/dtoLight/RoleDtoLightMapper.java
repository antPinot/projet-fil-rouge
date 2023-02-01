package fr.diginamic.GP3Covoiturage.dto.dtoLight;

import fr.diginamic.GP3Covoiturage.models.Role;

public class RoleDtoLightMapper {
	
	public static RoleDtoLight toDto(Role role) {

		RoleDtoLight dto = new RoleDtoLight(role.getId(), role.getName());

		return dto;

	}

}
