/**
 * 
 */
package fr.diginamic.GP3Covoiturage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.GP3Covoiturage.dto.AdresseDto;
import fr.diginamic.GP3Covoiturage.dto.AdresseDtoMapper;
import fr.diginamic.GP3Covoiturage.exceptions.FunctionalException;
import fr.diginamic.GP3Covoiturage.models.Adresse;
import fr.diginamic.GP3Covoiturage.repositories.AdresseRepository;
import jakarta.validation.Valid;

/**
 * @author antPinot
 *
 */

@Service
public class AdresseService {

	@Autowired
	private AdresseRepository adresseRepository;

	/** Create */
	public Adresse create(@Valid Adresse adresseToCreate) {
		List<Adresse> adresses = adresseRepository.findAll();
		if (adresses.stream().anyMatch(a -> a.equals(adresseToCreate))) {
			return null;
		}
		return adresseRepository.save(adresseToCreate);
	}

	/**
	 * @param id
	 * @return
	 * @throws RuntimeException
	 * @throws FunctionalException 
	 */
	public AdresseDto findById(Integer id) throws FunctionalException {
		Adresse model = adresseRepository.findById(id).orElseThrow(() -> new FunctionalException("L'adresse recherchée n'existe pas"));
		return AdresseDtoMapper.toDto(model);
	}

	/** Update */
	public Adresse update(@Valid Adresse adresseToUpdate) {
		Optional<Adresse> adresse = adresseRepository.findById(adresseToUpdate.getId());
		if (adresse.isPresent()) {
			adresseRepository.save(adresseToUpdate);
		}
		return null;
	}

	/**
	 * Delete
	 * 
	 * @throws AdresseNotFoundException
	 */
	public void delete(Integer id) throws RuntimeException {
		Optional<Adresse> adresseToDelete = adresseRepository.findById(id);
		if (adresseToDelete.isPresent()) {
			adresseRepository.delete(adresseToDelete.get());
		} else {
			throw new RuntimeException();
		}
	}

}
