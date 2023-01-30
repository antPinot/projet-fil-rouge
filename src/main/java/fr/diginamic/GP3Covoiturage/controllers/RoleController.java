package fr.diginamic.GP3Covoiturage.controllers;

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

import fr.diginamic.GP3Covoiturage.dto.CovoiturageDto;
import fr.diginamic.GP3Covoiturage.dto.CovoiturageDtoMapper;
import fr.diginamic.GP3Covoiturage.dto.RoleDto;
import fr.diginamic.GP3Covoiturage.dto.RoleDtoMapper;
import fr.diginamic.GP3Covoiturage.models.Covoiturage;
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
	public Role findOne(@PathVariable("id") Integer id) {
		return this.roleService.findById(null);
	}
	
	
	/**
	 * @method return list
	 */
	@GetMapping()
	public List<Role> getListRoles() {
		return roleService.findAll();
	}
	
	
	
	/**
	 * @method create
	 */
	@PostMapping()
	public RoleDto createRole(@RequestBody @Valid RoleDto createRole) {

		Role modelRole = RoleDtoMapper.toModel(createRole);
		roleService.create(modelRole);
		return createRole;
	}
	
	
	/**
	 * @method update
	 */
	@PutMapping("/{id}")
	public RoleDto updateRole(@PathVariable("id") Integer id,@Valid  RoleDto updateRole) {
		if (!id.equals(updateRole.getId())) {

			throw new RuntimeException("probleme : covoiturage existe pas");
		}

		Role modelRole = RoleDtoMapper.toModel(updateRole);
		roleService.update(modelRole);
		return updateRole;
	}
	
	
	
	/**
	 * @method delete
	 */
	@DeleteMapping("/{id}")
	public void deleteRole(@PathVariable("id") Integer id, @RequestBody @Valid Role deleteRole) {
		if (!id.equals(deleteRole.getId())) {
			throw new RuntimeException("Erreur : Covoiturage pas present en bdd");
		}
		this.roleService.delete(id);

	}


}
