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

import fr.diginamic.GP3Covoiturage.dto.VehiculePersonnelDto;
import fr.diginamic.GP3Covoiturage.dto.VehiculePersonnelDtoMapper;
import fr.diginamic.GP3Covoiturage.models.VehiculePersonnel;
import fr.diginamic.GP3Covoiturage.services.VehiculePersonnelService;

@RestController
@RequestMapping("rest/vehicule-personnel")
public class VehiculePersonnelController {
	
	@Autowired
	public VehiculePersonnelService vehiculePersonnelService;
	
	@PostMapping
	public VehiculePersonnelDto create(@RequestBody VehiculePersonnelDto vehiculePersonnelToCreate) {
		VehiculePersonnel modelVehiculePerso = VehiculePersonnelDtoMapper.toModel(vehiculePersonnelToCreate);
		vehiculePersonnelService.create(modelVehiculePerso);
		return vehiculePersonnelToCreate;
	}
	
	@PutMapping
	public VehiculePersonnelDto update(@RequestBody VehiculePersonnelDto vehiculePersonnelToUpdate) {
		VehiculePersonnel modelVehiculePerso = VehiculePersonnelDtoMapper.toModel(vehiculePersonnelToUpdate);
		vehiculePersonnelService.update(modelVehiculePerso);
		return vehiculePersonnelToUpdate;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		vehiculePersonnelService.delete(id);
	}
	
	@GetMapping("/{id}")
	public VehiculePersonnelDto findById(@PathVariable("id") Integer id) {
		return VehiculePersonnelDtoMapper.toDto(vehiculePersonnelService.findById(id));
	}
	
	@GetMapping()
	public List<VehiculePersonnel> findAllVehiculePersonnel() {
		return vehiculePersonnelService.findAll();
	}

}
