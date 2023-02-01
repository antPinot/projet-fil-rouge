/**
 * 
 */
package fr.diginamic.GP3Covoiturage.dto.dtoEdit;

import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.models.Covoiturage;
import fr.diginamic.GP3Covoiturage.models.VehiculePersonnel;
import fr.diginamic.GP3Covoiturage.utils.DateUtils;

/**
 * @author antPinot
 *
 */
public class CovoiturageDtoEditMapper {
	
	public static Covoiturage toModel (CovoiturageDtoEdit covoiturageEditDto) {
		Covoiturage model = new Covoiturage();
		VehiculePersonnel vehiculePersonnel = new VehiculePersonnel();
		vehiculePersonnel.setId(covoiturageEditDto.getVehiculePersonnelId());
		model.setId(covoiturageEditDto.getId());
		model.setDateDepart(DateUtils.stringToLocalDateTime(covoiturageEditDto.getDateDepart()));
		model.setPlacesRestantes(covoiturageEditDto.getPlacesRestantes());
		model.setNbPersonnes(covoiturageEditDto.getNbPersonnes());
		model.setDureeTrajet(covoiturageEditDto.getDureeTrajet());
		model.setDistance(covoiturageEditDto.getDistance());
		model.setOrganisateur(new Collaborateur(covoiturageEditDto.getOrganisateurId()));
		model.setVehiculePersonnel(vehiculePersonnel);
		model.setAdresseDepart(AdresseDtoEditMapper.toModel(covoiturageEditDto.getAdresseDepart()));
		model.setAdresseArrivee(AdresseDtoEditMapper.toModel(covoiturageEditDto.getAdresseArrivee()));
		
		return model;
	}

}
