package fr.diginamic.GP3Covoiturage.dto.dtoEdit;

import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.models.Covoiturage;
import fr.diginamic.GP3Covoiturage.models.VehiculePersonnel;
import fr.diginamic.GP3Covoiturage.utils.DateUtils;

/**
 * @author Fekhreddine
 */
public class CovoiturageDtoEditMapper {

	/**
	 * @method qui converti un Dto en modele
	 */

	public static Covoiturage toModel(CovoiturageDtoEdit covoiturageDto) {

		Covoiturage editDtoInModel = new Covoiturage();

		VehiculePersonnel vehiculePersonnel = new VehiculePersonnel();
		vehiculePersonnel.setId(covoiturageDto.getVehiculePersonnel());

		editDtoInModel.setId(covoiturageDto.getId());
		editDtoInModel.setDateDepart(DateUtils.stringToLocalDateTime(covoiturageDto.getDateDepart()));
		editDtoInModel.setPlacesRestantes(covoiturageDto.getPlacesRestantes());
		editDtoInModel.setNbPersonnes(covoiturageDto.getNbPersonnes());
		editDtoInModel.setDureeTrajet(covoiturageDto.getDureeTrajet());
		editDtoInModel.setDistance(covoiturageDto.getDistance());

		Collaborateur collaborateur = new Collaborateur();
		collaborateur.setId(covoiturageDto.getOrganisateur());

		editDtoInModel.setVehiculePersonnel(vehiculePersonnel);
		editDtoInModel.setAdresseArrivee(AdresseDtoEditMapper.toModel(covoiturageDto.getAdresseArrivee()));
		editDtoInModel.setAdresseDepart(AdresseDtoEditMapper.toModel(covoiturageDto.getAdresseDepart()));

		return editDtoInModel;
	}
}
