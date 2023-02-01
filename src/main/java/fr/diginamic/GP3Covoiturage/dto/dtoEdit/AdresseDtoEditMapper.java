/**
 * 
 */
package fr.diginamic.GP3Covoiturage.dto.dtoEdit;

import fr.diginamic.GP3Covoiturage.models.Adresse;

/**
 * @author antPinot
 *
 */
public class AdresseDtoEditMapper {

	public static Adresse toModel(AdresseDtoEdit adresseDtoEdit) {
		Adresse model = new Adresse();
		model.setId(adresseDtoEdit.getId());
		model.setNumero(adresseDtoEdit.getNumero());
		model.setComplementNumero(adresseDtoEdit.getComplementNumero());
		model.setVoie(adresseDtoEdit.getVoie());
		model.setCodePostal(adresseDtoEdit.getCodePostal());
		model.setDepartement(adresseDtoEdit.getDepartement());
		model.setPays(adresseDtoEdit.getPays());
		model.setVille(adresseDtoEdit.getVille());
		
		return model;
	}

}