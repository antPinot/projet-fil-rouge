package fr.diginamic.GP3Covoiturage.dto.dtoLight;

import fr.diginamic.GP3Covoiturage.models.Adresse;

/**
 * @author Fekhreddine
 * 
 * 
 */
public class AdresseDtoLightMapper {

	public static AdresseDtoLight toDto(Adresse adresse) {

		AdresseDtoLight lightDto = new AdresseDtoLight(adresse.getId(), adresse.getNumero(), adresse.getVoie(),
				adresse.getComplementNumero(), adresse.getCodePostal(), adresse.getVille(), adresse.getDepartement(),
				adresse.getPays());

		return lightDto;
	}

}
