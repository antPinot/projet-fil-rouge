/**
 * 
 */
package fr.diginamic.GP3Covoiturage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.GP3Covoiturage.dto.AdresseDto;
import fr.diginamic.GP3Covoiturage.dto.AdresseDtoMapper;
import fr.diginamic.GP3Covoiturage.dto.dtoEdit.AdresseDtoEdit;
import fr.diginamic.GP3Covoiturage.dto.dtoEdit.AdresseDtoEditMapper;
import fr.diginamic.GP3Covoiturage.exceptions.FunctionalException;
import fr.diginamic.GP3Covoiturage.models.Adresse;
import fr.diginamic.GP3Covoiturage.services.AdresseService;
import jakarta.validation.Valid;

/**
 * @author antPinot
 *
 */

@RestController
@RequestMapping("/rest/adresse")
public class AdresseController {

	@Autowired
	public AdresseService adresseService;

	/** Create 
	 **
	 * @param adresseToCreate
	 */
	@PostMapping
	public AdresseDtoEdit create(@RequestBody @Valid AdresseDtoEdit adresseToCreate) {
		Adresse model = AdresseDtoEditMapper.toModel(adresseToCreate);
		adresseService.create(model);
		return adresseToCreate;
	}
	
	@GetMapping("/{id}")
	public AdresseDto read(@PathVariable("id") Integer id) {
		try {
			return adresseService.findById(id);
		} catch (FunctionalException e) {
			System.out.println(e.getMessage()); 
			return null;
		}
	}

	/**
	 * @param adresseToUpdate
	 */
	@PutMapping
	public AdresseDtoEdit update(@RequestBody AdresseDtoEdit adresseToUpdate) {
		Adresse model = AdresseDtoEditMapper.toModel(adresseToUpdate);
		adresseService.update(model);
		return adresseToUpdate;
	}

	/**
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		adresseService.delete(id);
	}

}
