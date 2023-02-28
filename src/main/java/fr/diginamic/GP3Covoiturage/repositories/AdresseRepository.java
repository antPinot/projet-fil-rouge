/**
 * 
 */
package fr.diginamic.GP3Covoiturage.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.diginamic.GP3Covoiturage.models.Adresse;

/**
 * Repository de l'entité Adresse fournissant des méthodes d'accès à la 
 * base de données
 * @author antPinot
 *
 */

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Integer> {
	
	/**
	 * 
	 * Query permettant de gérer les doublons d'Adresse
	 * 
	 * @param numero
	 * @param complementNumero
	 * @param voie
	 * @param codePostal
	 * @param departement
	 * @param pays
	 * @param ville
	 * @return
	 */
	@Query("FROM Adresse a WHERE a.numero = :num AND a.complementNumero = :compNum AND a.voie = :voie AND a.codePostal = :codePos AND a.departement = :dep AND a.pays = :pays AND a.ville = :ville")
	public List<Adresse> findExistingAdresse(@Param ("num")Integer numero,
			@Param ("compNum") String complementNumero,
			@Param ("voie") String voie,
			@Param ("codePos") Integer codePostal,
			@Param ("dep") String departement,
			@Param ("pays") String pays,
			@Param ("ville") String ville);

}

