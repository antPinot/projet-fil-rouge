/**
 * 
 */
package fr.diginamic.GP3Covoiturage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.GP3Covoiturage.models.Adresse;

/**
 * @author antPinot
 *
 */

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Integer> {

}
