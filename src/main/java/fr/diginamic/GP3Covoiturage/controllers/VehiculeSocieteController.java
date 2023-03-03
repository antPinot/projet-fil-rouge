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

import fr.diginamic.GP3Covoiturage.dto.dtoEdit.VehiculeSocieteDtoEdit;
import fr.diginamic.GP3Covoiturage.dto.dtoEdit.VehiculeSocieteDtoEditMapper;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.VehiculeSocieteDtoLight;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.VehiculeSocieteDtoLightMapper;
import fr.diginamic.GP3Covoiturage.exceptions.FunctionalException;
import fr.diginamic.GP3Covoiturage.models.VehiculeSociete;
import fr.diginamic.GP3Covoiturage.services.VehiculeSocieteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("rest/vehicule-societe")
public class VehiculeSocieteController {

	@Autowired
	private VehiculeSocieteService vehiculeSocieteService;
	
	@PostMapping
	public VehiculeSocieteDtoEdit create(@RequestBody @Valid VehiculeSocieteDtoEdit vehiculeSocieteToCreate) {
		VehiculeSociete modelVehiculeSociete = VehiculeSocieteDtoEditMapper.toModel(vehiculeSocieteToCreate);
		vehiculeSocieteService.create(modelVehiculeSociete);
		return vehiculeSocieteToCreate;
	}

	@PutMapping("/{id}")
	public VehiculeSocieteDtoEdit update(@RequestBody @Valid VehiculeSocieteDtoEdit vehiculeSocieteToUpdate) {
		VehiculeSociete modelVehiculeSociete = VehiculeSocieteDtoEditMapper.toModel(vehiculeSocieteToUpdate);
		vehiculeSocieteService.update(modelVehiculeSociete);
		return vehiculeSocieteToUpdate;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		vehiculeSocieteService.delete(id);
	}

	@GetMapping("/{id}")
	public VehiculeSocieteDtoLight findById(@PathVariable("id") Integer id) {
		return VehiculeSocieteDtoLightMapper.toDto(vehiculeSocieteService.findById(id));
	}

	@GetMapping()
	public List<VehiculeSocieteDtoLight> findAllVehiculeSociete() {
		List<VehiculeSociete> models = vehiculeSocieteService.findAll();
		List<VehiculeSocieteDtoLight> dtos = new ArrayList<>();
		models.forEach(m -> dtos.add(VehiculeSocieteDtoLightMapper.toDto(m)));
		return dtos;
	}

	/**
	 * Get METHODE
	 * 
	 * EN PENDING
	 * 
	 **/
	@GetMapping("/searchVehiculeSocietes")
	public List<VehiculeSocieteDtoLight> searchVehiculeSociete(
			@RequestParam(value = "dateDepart") String dateDepart,
			@RequestParam(value = "dateRetour") String dateRetour) {

		List<VehiculeSociete> vehiculeSocietes = vehiculeSocieteService.getVehiculesSocietesDispo(dateDepart,
				dateRetour);
		List<VehiculeSocieteDtoLight> dtos = new ArrayList<>();

		vehiculeSocietes.forEach(m -> dtos.add(VehiculeSocieteDtoLightMapper.toDto(m)));
		return dtos;
	}
	
	@GetMapping("/{marque}")
	public List<VehiculeSocieteDtoLight> findByMarque(@PathVariable("marque") String marque) {
		List<VehiculeSociete> models = vehiculeSocieteService.findByMarque(marque);
		List<VehiculeSocieteDtoLight> dtos = new ArrayList<>();
		models.forEach(m -> dtos.add(VehiculeSocieteDtoLightMapper.toDto(m)));
		return dtos;
	}
	
	@GetMapping("/{immatriculation}")
	public List<VehiculeSocieteDtoLight> findByImmatriculation(@PathVariable("immatriculation") String immatriculation) {
		List<VehiculeSociete> models = vehiculeSocieteService.findByImmatriculation(immatriculation);
		List<VehiculeSocieteDtoLight> dtos = new ArrayList<>();
		models.forEach(m -> dtos.add(VehiculeSocieteDtoLightMapper.toDto(m)));
		return dtos;
	}

	/** methode fonctionnel **/

	@PostMapping("/createVehiculeSociete")
	public VehiculeSocieteDtoEdit createVehiculeSociete(@RequestBody VehiculeSocieteDtoEdit vehiculeSocieteDtoEdit) {

		VehiculeSociete modelVehiculeSociete = VehiculeSocieteDtoEditMapper.toModel(vehiculeSocieteDtoEdit);

		try {

			vehiculeSocieteService.createVehicule(modelVehiculeSociete);

			return vehiculeSocieteDtoEdit;

		} catch (FunctionalException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());

			return null;
		}

	}

	/**
	 * MAJ voiture de service
	 * 
	 * 
	 **/
	@PutMapping("/MAJVehiculeSociete/{id}")
	public VehiculeSocieteDtoEdit majVehiculeSociete(
			@RequestBody @Valid VehiculeSocieteDtoEdit vehiculeSocieteDtoEdit) {

		VehiculeSociete modelVehiculeSociete = VehiculeSocieteDtoEditMapper.toModel(vehiculeSocieteDtoEdit);
		try {

			vehiculeSocieteService.updateVehicule(modelVehiculeSociete);
			return vehiculeSocieteDtoEdit;
		} catch (FunctionalException e) {

			System.err.println(e.getMessage());

			return null;
		}
	}

}
