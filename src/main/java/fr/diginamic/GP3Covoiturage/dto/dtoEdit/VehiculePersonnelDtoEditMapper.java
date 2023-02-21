/**
 * 
 */
package fr.diginamic.GP3Covoiturage.dto.dtoEdit;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.models.VehiculePersonnel;

/**
 * @author antPinot
 *
 */
public class VehiculePersonnelDtoEditMapper {

	public static VehiculePersonnel toModel(VehiculePersonnelDtoEdit vehiculePersonnelDtoEdit) {
		List<Collaborateur> collaborateurs = new ArrayList<>();

		for (Integer collaborateurId : vehiculePersonnelDtoEdit.getCollaborateursId()) {
			collaborateurs.add(new Collaborateur(collaborateurId));
		}

		VehiculePersonnel model = new VehiculePersonnel();
		model.setId(vehiculePersonnelDtoEdit.getId());
		model.setImmatriculation(vehiculePersonnelDtoEdit.getImmatriculation());
		model.setMarque(vehiculePersonnelDtoEdit.getMarque());
		model.setModele(vehiculePersonnelDtoEdit.getModele());
		model.setPlaces(vehiculePersonnelDtoEdit.getPlaces());
		model.setLimitePlace(vehiculePersonnelDtoEdit.getLimitePlace());
		model.setCollaborateurs(collaborateurs);
		
		return model;
	}

}
