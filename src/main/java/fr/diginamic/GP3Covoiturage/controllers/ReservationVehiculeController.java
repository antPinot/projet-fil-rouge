/**
 * 
 */
package fr.diginamic.GP3Covoiturage.controllers;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.GP3Covoiturage.dto.dtoEdit.ReservationVehiculeDtoEdit;
import fr.diginamic.GP3Covoiturage.dto.dtoEdit.ReservationVehiculeDtoEditMapper;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.CovoiturageDtoLight;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.CovoiturageDtoLightMapper;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.ReservationVehiculeDtoLight;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.ReservationVehiculeDtoLightMapper;
import fr.diginamic.GP3Covoiturage.models.Covoiturage;
import fr.diginamic.GP3Covoiturage.models.ReservationVehicule;
import fr.diginamic.GP3Covoiturage.services.ReservationVehiculeService;
import jakarta.validation.Valid;

/**
 * @author antPinot
 *
 */

@RestController
@RequestMapping("/rest/reservation-vehicule")
public class ReservationVehiculeController {
	
	@Autowired
	public ReservationVehiculeService reservationVehiculeService;
	
	/**
	 * Utilise un EditDto
	 * 
	 * @param reservationVehiculeDtoToCreate
	 * @return reservationVehiculeDtoToCreate
	 */
	@PostMapping
	@ResponseBody
	public ResponseEntity<String> create(@RequestBody @Valid ReservationVehiculeDtoEdit reservationVehiculeDtoToCreate, Errors errors) {
		if (errors.hasErrors()) {
			return new ResponseEntity<String>("ERROR", HttpStatus.BAD_REQUEST);
		}
		ReservationVehicule model = ReservationVehiculeDtoEditMapper.toModel(reservationVehiculeDtoToCreate);
		reservationVehiculeService.create(model);
		//return reservationVehiculeDtoToCreate;
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		return new ResponseEntity<String>("Hey", headers, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ReservationVehiculeDtoLight read(@PathVariable("id") Integer id) {
		return ReservationVehiculeDtoLightMapper.toDto(reservationVehiculeService.findById(id));
	}
	
	@GetMapping("/")
	public List<ReservationVehiculeDtoLight> readByCollaborateur(@RequestParam Integer collaborateurId,
			@RequestParam String state) {
			List<ReservationVehicule> models = reservationVehiculeService.findByCollaborateur(collaborateurId, state);
			List<ReservationVehiculeDtoLight> dtos = new ArrayList<>();
			models.forEach(m -> dtos.add(ReservationVehiculeDtoLightMapper.toDto(m)));
			return dtos;
	}
	
	@GetMapping
	public List<ReservationVehiculeDtoLight> readAll(){
		List<ReservationVehicule> models = reservationVehiculeService.findAll();
		List<ReservationVehiculeDtoLight> dtos = new ArrayList<>();
		models.forEach(m -> dtos.add(ReservationVehiculeDtoLightMapper.toDto(m)));
		return dtos;
	}
	
	/**
	 * Utilise un EditDto
	 * 
	 * @param reservationVehiculeDtoToUpdate
	 * @return
	 */
	@PutMapping

	public ReservationVehiculeDtoEdit update(@RequestBody @Valid  ReservationVehiculeDtoEdit reservationVehiculeDtoToUpdate) {
		ReservationVehicule model = ReservationVehiculeDtoEditMapper.toModel(reservationVehiculeDtoToUpdate);
		reservationVehiculeService.update(model);
		return reservationVehiculeDtoToUpdate;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		reservationVehiculeService.delete(id);
	}

}
