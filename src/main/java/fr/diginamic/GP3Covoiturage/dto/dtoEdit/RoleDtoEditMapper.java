package fr.diginamic.GP3Covoiturage.dto.dtoEdit;

import fr.diginamic.GP3Covoiturage.models.Role;

/**
 * @author Fekhreddine
 */
public class RoleDtoEditMapper {

	/**
	 * @author Fekhreddine
	 * 
	 *  methode toModel qui transforme un dto en modele en POST
	 */

	public static Role toModel(RoleDtoEdit roleDto) {

		Role editDtoInModel = new Role();

		editDtoInModel.setId(roleDto.getId());
		editDtoInModel.setName(roleDto.getName());
		return editDtoInModel;

	}

}
