/**
 * 
 */
package fr.diginamic.GP3Covoiturage.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import fr.diginamic.GP3Covoiturage.dto.dtoEdit.AdresseDtoEdit;
import fr.diginamic.GP3Covoiturage.dto.dtoEdit.AdresseDtoEditMapper;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.AdresseDtoLight;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.AdresseDtoLightMapper;
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
	private AdresseService adresseService;

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
	public AdresseDtoLight read(@PathVariable("id") Integer id) {
		return AdresseDtoLightMapper.toDto(adresseService.findById(id));
	}
	
	@GetMapping
	public List<AdresseDtoLight> readAll(){
		List<Adresse> models = adresseService.findAll();
		List<AdresseDtoLight> dtos = new ArrayList<>();
		models.forEach(m -> dtos.add(AdresseDtoLightMapper.toDto(m)));
		return dtos;
	}

	/**
	 * @param adresseToUpdate
	 */
	@PutMapping
	public AdresseDtoEdit update(@RequestBody @Valid AdresseDtoEdit adresseToUpdate) {
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
	
	@GetMapping("/autocomplete")
	public List<AdresseDtoLight> readByUserQuery(@RequestParam String userQuery){
		List<Adresse> models = adresseService.readByUserQuery(userQuery);
		List<AdresseDtoLight> dtos = new ArrayList<>();
		models.forEach(a -> dtos.add(AdresseDtoLightMapper.toDto(a)));
		return dtos;
	}

}
