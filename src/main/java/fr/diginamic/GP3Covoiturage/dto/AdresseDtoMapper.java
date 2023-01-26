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
	
	public static AdresseDto toDto(Adresse adresse){
		
		AdresseDto dto = new AdresseDto(adresse.getId(), 
				adresse.getNumero(), 
				adresse.getComplementNumero(), 
				adresse.getVoie(), 
				adresse.getCodePostal(), 
				adresse.getDepartement(), 
				adresse.getPays(), 
				adresse.getVille(), 
				MapperCovoiturage.methodeStatic(adresse.getCovoiturageDepart()), 
				MapperCovoiturage.methodeStatic(adresse.getCovoiturageArrivee()));
		
		return dto;
		
	}

}
