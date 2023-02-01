package fr.diginamic.GP3Covoiturage.dto;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.GP3Covoiturage.models.Role;

/**
 * @author Fekhreddine
 */
public class RoleDtoMapper {

	public static RoleDto toDto(Role role) {

		RoleDto dto = new RoleDto(role.getId(), role.getName(),
				CollaborateurDtoMapper.listToDto(role.getCollaborateurs()));

		return dto;

	}

	/**
	 * methode qui retourne une liste de RoleDto
	 * 
	 */
	public static List<RoleDto> listToDto(List<Role> roles) {
		List<RoleDto> listRoleDto = new ArrayList<>();
		roles.forEach(c -> listRoleDto.add(RoleDtoMapper.toDto(c)));
		return listRoleDto;
	}

	/**
	 * methode qui retourne une liste de role
	 * 
	 */
	/*public static List<Role> listToModels(List<RoleDto> rolesDto) {

		List<Role> listModelsRoles = new ArrayList<>();

		rolesDto.forEach(c -> listModelsRoles.add(RoleDtoMapper.toModel(c)));

		return listModelsRoles;
	}*/

	/**
	 * methode toModel qui retourne un modele
	 * 
	 */
	/*public static Role toModel(RoleDto c) {

		Role modelRole = new Role(c.getId(), c.getName(), CollaborateurDtoMapper.listToModels(c.getCollaborateurs()));

		return modelRole;
	}*/

}
