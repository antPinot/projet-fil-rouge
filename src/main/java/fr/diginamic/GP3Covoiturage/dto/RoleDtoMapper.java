package fr.diginamic.GP3Covoiturage.dto;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.GP3Covoiturage.models.Role;

/**
 * @author Fekhreddine
 */
public class RoleDtoMapper {

	public static RoleDto toDto(Role role) {

		RoleDto dto = new RoleDto(role.getId(), role.getName(), CollaborateurDtoMapper.listToDto(role.getCollaborateurs()));

		return dto;

	}

	public static List<RoleDto> listToDto(List<Role> roles) {
		List<RoleDto> listRoleDto = new ArrayList<>();
		roles.forEach(c -> listRoleDto.add(RoleDtoMapper.toDto(c)));
		return listRoleDto;
	}

}
