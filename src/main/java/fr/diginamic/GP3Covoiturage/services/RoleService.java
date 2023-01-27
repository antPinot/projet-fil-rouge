package fr.diginamic.GP3Covoiturage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import fr.diginamic.GP3Covoiturage.models.Role;
import fr.diginamic.GP3Covoiturage.repositories.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

/**
 * @author Fekhreddine
 */
public class RoleService {

	@Autowired
	RoleRepository roleRepository;

	/**
	 * @method services de CRUD basique
	 */

	public Role create(@Valid Role createRole) {

		if (createRole.getId() != null) {
			throw new RuntimeException("erreur : id role existe deja present");
		}
		return this.roleRepository.save(createRole);
	}

	public Role update(@Valid Role updateRole) {

		if (updateRole.getId() == null) {

			throw new RuntimeException("erreur : le role n'est pas encore créer");
		}
		return this.roleRepository.save(updateRole);
	}

	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	public Role findById(Integer id) {
		return this.roleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	public void delete(Integer id) {

		if (id == null) {
			throw new RuntimeException("erreur : id role pas present");
		}
		this.roleRepository.deleteById(id);
	}

}
