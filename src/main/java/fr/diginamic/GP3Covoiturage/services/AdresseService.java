/**
 * 
 */
package fr.diginamic.GP3Covoiturage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import fr.diginamic.GP3Covoiturage.exceptions.BadRequestException;
import fr.diginamic.GP3Covoiturage.exceptions.EntityNotFoundException;
import fr.diginamic.GP3Covoiturage.models.Adresse;
import fr.diginamic.GP3Covoiturage.repositories.AdresseRepository;
import jakarta.validation.Valid;

/**
 * Classe de service fournissant des méthodes de contrôle métier et faisant
 * appel au repository de la classe Adresse
 * 
 * @author antPinot
 *
 */

@Service
public class AdresseService {

	@Autowired
	private AdresseRepository adresseRepository;

	
	/**
	 * 
	 * 
	 * @param adresseToCreate
	 * @return
	 */
	public Adresse create(@Valid Adresse adresseToCreate) {
		List<Adresse> adresses = findExistingAdresse(adresseToCreate.getNumero(), adresseToCreate.getComplementNumero(), adresseToCreate.getVoie(), adresseToCreate.getCodePostal(), adresseToCreate.getDepartement(), adresseToCreate.getPays(), adresseToCreate.getVille());
		if (adresses.stream().anyMatch(a -> a.equals(adresseToCreate))) {
			throw new BadRequestException("L'adresse existe déjà en base");
		}
		return adresseRepository.save(adresseToCreate);
	}

	/**
	 * Retrouve une adresse en fonction de son id
	 * 
	 * @param id
	 * @return
	 * @throws RuntimeException
	 * @throws FunctionalException 
	 */
	public Adresse findById(Integer id) throws EntityNotFoundException  {
		return adresseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("L'adresse recherchée n'existe pas"));
	}
	
	/**
	 * Récupère toutes les adresses stockées en base
	 * 
	 * @return
	 */
	public List<Adresse> findAll(){
		return adresseRepository.findAll();
	}
	
	/**
	 * Méthode permettant de retrouver une adresse existante. Utilisée notamment dans CovoiturageService
	 * pour éviter d'enregistrer des doublons d'adresse en base.
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
	public List<Adresse> findExistingAdresse(Integer numero, String complementNumero, String voie, Integer codePostal, String departement, String pays, String ville){
		return adresseRepository.findExistingAdresse(numero, complementNumero, voie, codePostal, departement, pays, ville);
	}

	
	/**
	 * @param adresseToUpdate
	 * @return
	 */
	public Adresse update(@Valid Adresse adresseToUpdate) {
		Optional<Adresse> adresse = adresseRepository.findById(adresseToUpdate.getId());
		if (adresse.isPresent()) {
			adresseRepository.save(adresseToUpdate);
		}
		return null;
	}

	/**
	 * Delete
	 * @throws FunctionalException 
	 * 
	 * @throws AdresseNotFoundException
	 */
	public void delete(Integer id) throws EntityNotFoundException {
		Optional<Adresse> adresseToDelete = adresseRepository.findById(id);
		if (adresseToDelete.isPresent()) {
			adresseRepository.delete(adresseToDelete.get());
		} else {
			throw new EntityNotFoundException("Il n'y a pas d'entité à effacer");
		}
	}
	
	public List<Adresse> readByUserQuery(String query){
		return adresseRepository.findByUserQuery(query);
	}

}
