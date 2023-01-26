/**
 * 
 */
package fr.diginamic.GP3Covoiturage.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import fr.diginamic.GP3Covoiturage.models.Adresse;
import fr.diginamic.GP3Covoiturage.models.Covoiturage;

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
				CovoiturageDtoMapper.listToDto(adresse.getCovoiturageDepart()), 
				CovoiturageDtoMapper.listToDto(adresse.getCovoiturageArrivee()));
		
		return dto;
		
	}
	
	public static List<AdresseDto> listToDto(List<Adresse> adresses){
		List<AdresseDto> listDto = new ArrayList<>();
		adresses.forEach(a -> listDto.add(AdresseDtoMapper.toDto(a)));
		return listDto;
	}
	
	
}
