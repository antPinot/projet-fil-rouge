package fr.diginamic.GP3Covoiturage.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.models.Role;

/**
 * @author Fekhreddine
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	//public List<Role> findByCollaborateurs(List<Collaborateur> collaborateurs);  

	public List<Role> findByName(String name);

	
	/**
	    * @method qui selectionne tous les roles
	    * par collaborateur
	    */
	@Query("SELECT DISTINCT r FROM Role r JOIN r.collaborateurs c WHERE c =:collaborateur")
	public List<Role> findByAllRolesByCollaborateurs(@Param("collaborateur") Collaborateur collaborateur);

}
