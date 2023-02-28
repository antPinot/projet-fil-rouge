package fr.diginamic.GP3Covoiturage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.GP3Covoiturage.models.Role;
import fr.diginamic.GP3Covoiturage.repositories.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

/**
 * @author Fekhreddine
 */

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;

	/**
	 * @method create()
	 */
	public Role create(@Valid Role createRole) {

		if (createRole.getId() != null) {
			throw new RuntimeException("erreur : id role existe deja present");
		}

		 
		return this.roleRepository.save(createRole);

	}

	/**
	 * @method update()
	 */
	public Role update(@Valid Role updateRole) {

		if (updateRole.getId() == null) {

			throw new RuntimeException("erreur : le role n'est pas encore créer");
		}
 
		return this.roleRepository.save(updateRole);

	}

	/**
	 * @method findAll()
	 */
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	/**
	 * @method findById()
	 */
	public Role findById(Integer id) {
		return this.roleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	/**
	 * @method delete()
	 */
	public void delete(Integer id) {

		if (id == null) {
			throw new RuntimeException("erreur : id role pas present");
		}
		this.roleRepository.deleteById(id);
	}

}
