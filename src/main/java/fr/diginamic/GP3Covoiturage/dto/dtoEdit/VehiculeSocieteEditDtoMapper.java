/**
 * 
 */
package fr.diginamic.GP3Covoiturage.dto.dtoEdit;

import fr.diginamic.GP3Covoiturage.enums.Categorie;
import fr.diginamic.GP3Covoiturage.models.VehiculeSociete;

/**
 * @author antPinot
 *
 */
public class VehiculeSocieteEditDtoMapper {
	
	public static VehiculeSociete toModel(VehiculeSocieteEditDto vehiculeSocieteEditDto) {
		VehiculeSociete model = new VehiculeSociete();
		model.setId(vehiculeSocieteEditDto.getId());
		model.setImmatriculation(vehiculeSocieteEditDto.getImmatriculation());
		model.setMarque(vehiculeSocieteEditDto.getMarque());
		model.setModele(vehiculeSocieteEditDto.getModele());
		model.setPlaces(vehiculeSocieteEditDto.getPlaces());
		model.setPhoto(vehiculeSocieteEditDto.getPhoto());
		model.setDisponible(vehiculeSocieteEditDto.isDisponible());
		model.setStatut(vehiculeSocieteEditDto.getStatut());
		model.setCategorie(Categorie.valueOfName(vehiculeSocieteEditDto.getCategorie()));
		
		return model;
	}

}
