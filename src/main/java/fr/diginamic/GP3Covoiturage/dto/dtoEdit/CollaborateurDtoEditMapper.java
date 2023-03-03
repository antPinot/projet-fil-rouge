package fr.diginamic.GP3Covoiturage.dto.dtoEdit;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.models.Role;
import fr.diginamic.GP3Covoiturage.utils.DateUtils;

/** Classe CollaborateurDto
 * 
 * @author Quentin
 */

public class CollaborateurDtoEditMapper {
	
	public static Collaborateur toModel (CollaborateurDtoEdit collaborateurDtoEdit) {
		
		List<Role> roles = new ArrayList<>();
		
		Collaborateur model = new Collaborateur();
		model.setId(collaborateurDtoEdit.getId());		
		model.setMatricule(collaborateurDtoEdit.getMatricule());
		model.setNom(collaborateurDtoEdit.getNom());
		model.setPrenom(collaborateurDtoEdit.getPrenom());
		model.setDateNaissance(DateUtils.stringToLocalDate(collaborateurDtoEdit.getDateNaissance()));
		model.setTelephone(collaborateurDtoEdit.getTelephone());
		model.setMail(collaborateurDtoEdit.getMail());
		model.setLogin(collaborateurDtoEdit.getLogin());
		model.setPassword(collaborateurDtoEdit.getPassword());
		model.setDateCreation(DateUtils.stringToLocalDate(collaborateurDtoEdit.getDateCreation()));
		
		collaborateurDtoEdit.getRolesId().forEach(r -> roles.add(new Role(r)));
		model.setRoles(roles);
		
		return model;
	}

}
