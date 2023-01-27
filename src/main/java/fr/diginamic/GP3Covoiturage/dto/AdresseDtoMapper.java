/**
 * 
 */
package fr.diginamic.GP3Covoiturage.dto;

import org.springframework.stereotype.Component;

import fr.diginamic.GP3Covoiturage.models.Adresse;

/**
 * @author antPinot
 *
 */

@Component
public class AdresseDtoMapper {
	
	/**
	 * @param adresse
	 * @return
	 */
	public static AdresseDto toDto(Adresse adresse){
		
		AdresseDto dto = new AdresseDto(adresse.getId(), 
				adresse.getNumero(), 
				adresse.getComplementNumero(), 
				adresse.getVoie(), 
				adresse.getCodePostal(), 
				adresse.getDepartement(), 
				adresse.getPays(), 
				adresse.getVille(), 
				CovoiturageDtoMapper.listToDto(adresse.getCovoiturageDepart()), 
				CovoiturageDtoMapper.listToDto(adresse.getCovoiturageArrivee()));
		
		return dto;
		
	}
	
	/**
	 * @param adresseDto
	 * @return
	 */
	public static Adresse toModel(AdresseDto adresseDto) {
		Adresse model = new Adresse(adresseDto.getId(), 
				adresseDto.getNumero(), 
				adresseDto.getComplementNumero(), 
				adresseDto.getVoie(), 
				adresseDto.getCodePostal(),
				adresseDto.getDepartement(), 
				adresseDto.getPays(),
				adresseDto.getVille(), 
				CovoiturageDtoMapper.listToModels(adresseDto.getCovoiturageDepart()), 
				CovoiturageDtoMapper.listToModels(adresseDto.getCovoiturageArrivee()));
		
		return model;
	}

}
