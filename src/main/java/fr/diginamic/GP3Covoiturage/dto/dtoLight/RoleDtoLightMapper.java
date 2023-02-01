package fr.diginamic.GP3Covoiturage.dto.dtoLight;

import fr.diginamic.GP3Covoiturage.models.Role;

/**
 * @author Fekhreddine
 * 
 * methode toDto qui transforme un modele en dto
 */
public class RoleDtoLightMapper {

	public static RoleDtoLight toDto(Role role) {

		RoleDtoLight lightDto = new RoleDtoLight(role.getId(), role.getName());

		return lightDto;
	}

}
