package fr.diginamic.GP3Covoiturage.Dto;

import fr.diginamic.GP3Covoiturage.models.Role;

/**
 * @author Fekhreddine
 */
public class RoleDtoMapper {

	public static RoleDto toDto(Role role) {

		RoleDto dto = new RoleDto(role.getId(), role.getName(), CollaborateurDtoMapper.toDto(role.getCollaborateurs()));

		return dto;

	}

}
