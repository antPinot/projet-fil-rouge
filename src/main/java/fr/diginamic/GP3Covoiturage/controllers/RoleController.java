package fr.diginamic.GP3Covoiturage.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.GP3Covoiturage.dto.dtoEdit.RoleDtoEdit;
import fr.diginamic.GP3Covoiturage.dto.dtoEdit.RoleDtoEditMapper;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.RoleDtoLight;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.RoleDtoLightMapper;
import fr.diginamic.GP3Covoiturage.models.Role;
import fr.diginamic.GP3Covoiturage.services.RoleService;
import jakarta.validation.Valid;

/**
 * @author Fekhreddine
 */

@RestController
@RequestMapping("/rest/role")
public class RoleController {

	@Autowired
	RoleService roleService;

	/**
	 * @method return a id
	 */
	@GetMapping("/{id}")
	public RoleDtoLight findOne(@PathVariable("id") Integer id) {

		Role role = roleService.findById(id);
		if (role == null) {
			throw new RuntimeException("probleme : id role existe pas");
		}
		RoleDtoLight roleDtoLight = RoleDtoLightMapper.toDto(role);
		return roleDtoLight;
	}

	/**
	 * @method return list
	 */
	@GetMapping()
	public List<RoleDtoLight> getListRoles() {
		List<Role> roles = roleService.findAll();
		List<RoleDtoLight> roleDtoLights = new ArrayList<>();
		for (Role role : roles) {
			roleDtoLights.add(RoleDtoLightMapper.toDto(role));
		}
		return roleDtoLights; // Faire une boucle qui converti tous les dto en dtolight
	}

	/**
	 * @method create
	 */
	@PostMapping()
	public @Valid RoleDtoEdit createRole(@RequestBody @Valid RoleDtoEdit createRole) {

		Role modelRole = RoleDtoEditMapper.toModel(createRole);
		roleService.create(modelRole);
		return createRole;
	}

	/**
	 * @method update
	 */
	@PutMapping("/{id}")
	public @Valid RoleDtoEdit updateRole(@PathVariable("id") Integer id,@RequestBody @Valid RoleDtoEdit updateRole) {
		if (!id.equals(updateRole.getId())) {

			throw new RuntimeException("probleme : covoiturage existe pas");
		}

		Role modelRole = RoleDtoEditMapper.toModel(updateRole);
		roleService.update(modelRole);
		return updateRole;
	}

	/**
	 * @method delete
	 */
	@DeleteMapping("/{id}")
	public void deleteRole(@PathVariable("id") Integer id,   Role deleteRole) {
		if (!id.equals(deleteRole.getId())) {
			throw new RuntimeException("Erreur : Covoiturage pas present en bdd");
		}
		this.roleService.delete(id);

	}

}
