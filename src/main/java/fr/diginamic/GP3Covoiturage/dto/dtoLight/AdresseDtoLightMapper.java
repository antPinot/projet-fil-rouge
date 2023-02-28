package fr.diginamic.GP3Covoiturage.dto.dtoLight;

import fr.diginamic.GP3Covoiturage.models.Adresse;

/**
 * @author Fekhreddine
 * 
 * 
 */
public class AdresseDtoLightMapper {

	public static AdresseDtoLight toDto(Adresse adresse) {

		AdresseDtoLight lightDto = new AdresseDtoLight(adresse.getId(), adresse.getNumero(),
				adresse.getComplementNumero(), adresse.getVoie(), adresse.getCodePostal(), adresse.getDepartement(), adresse.getPays(),
				 adresse.getVille());

		return lightDto;
	}

}
