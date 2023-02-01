package fr.diginamic.GP3Covoiturage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.GP3Covoiturage.dto.VehiculeSocieteDto;
import fr.diginamic.GP3Covoiturage.dto.VehiculeSocieteDtoMapper;
import fr.diginamic.GP3Covoiturage.dto.dtoEdit.VehiculeSocieteEditDto;
import fr.diginamic.GP3Covoiturage.dto.dtoEdit.VehiculeSocieteEditDtoMapper;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.VehiculeSocieteDtoLight;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.VehiculeSocieteDtoLightMapper;
import fr.diginamic.GP3Covoiturage.models.VehiculeSociete;
import fr.diginamic.GP3Covoiturage.services.VehiculeSocieteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("rest/vehicule-societe")
public class VehiculeSocieteController {
	
	@Autowired
	public VehiculeSocieteService vehiculeSocieteService;
	
	@PostMapping
	public VehiculeSocieteEditDto create(@RequestBody @Valid VehiculeSocieteEditDto vehiculeSocieteToCreate) {
		VehiculeSociete modelVehiculeSociete = VehiculeSocieteEditDtoMapper.toModel(vehiculeSocieteToCreate);
		vehiculeSocieteService.create(modelVehiculeSociete);
		return vehiculeSocieteToCreate;
	}
	
	@PutMapping("/{id}")
	public VehiculeSocieteEditDto update(@RequestBody @Valid VehiculeSocieteEditDto vehiculeSocieteToUpdate) {
		VehiculeSociete modelVehiculeSociete = VehiculeSocieteEditDtoMapper.toModel(vehiculeSocieteToUpdate);
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
	public List<VehiculeSociete> findAllVehiculeSociete() {
		return vehiculeSocieteService.findAll();
	}

}
