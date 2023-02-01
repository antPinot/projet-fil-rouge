package fr.diginamic.GP3Covoiturage.dto.dtoEdit;

import fr.diginamic.GP3Covoiturage.models.Collaborateur;

/** Classe CollaborateurDto
 * 
 * @author Quentin
 */

public class CollaborateurDtoEditMapper {
	
	public static Collaborateur toModel (CollaborateurDtoEdit collaborateurDtoEdit) {
		
		Collaborateur model = new Collaborateur(collaborateurDtoEdit.getId(),
				collaborateurDtoEdit.getMatricule(),
				collaborateurDtoEdit.getNom(),
				collaborateurDtoEdit.getPrenom(),
				collaborateurDtoEdit.getDateNaissance(),
				collaborateurDtoEdit.getTelephone(),
				collaborateurDtoEdit.getMail(),
				collaborateurDtoEdit.getLogin(),
				collaborateurDtoEdit.getPassword(),
				collaborateurDtoEdit.getDateCreation()
				);
		
		return model;
	}

}
