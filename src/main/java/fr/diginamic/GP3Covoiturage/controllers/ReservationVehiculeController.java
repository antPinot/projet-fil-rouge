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

import fr.diginamic.GP3Covoiturage.dto.dtoEdit.ReservationVehiculeDtoEdit;
import fr.diginamic.GP3Covoiturage.dto.dtoEdit.ReservationVehiculeDtoEditMapper;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.ReservationVehiculeDtoLight;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.ReservationVehiculeDtoLightMapper;

import fr.diginamic.GP3Covoiturage.exceptions.FunctionalException;

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
	private ReservationVehiculeService reservationVehiculeService;

	/**
	 * Utilise un EditDto
	 * 
	 * @param reservationVehiculeDtoToCreate
	 * @return reservationVehiculeDtoToCreate
	 */
	@PostMapping
  
	public ReservationVehiculeDtoEdit create(
			@RequestBody @Valid ReservationVehiculeDtoEdit reservationVehiculeDtoToCreate) {
		ReservationVehicule model = ReservationVehiculeDtoEditMapper.toModel(reservationVehiculeDtoToCreate);
		reservationVehiculeService.create(model);
		return reservationVehiculeDtoToCreate;
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
	public List<ReservationVehiculeDtoLight> readAll() {
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
	public ReservationVehiculeDtoEdit update(
			@RequestBody @Valid ReservationVehiculeDtoEdit reservationVehiculeDtoToUpdate) {
		ReservationVehicule model = ReservationVehiculeDtoEditMapper.toModel(reservationVehiculeDtoToUpdate);
		reservationVehiculeService.update(model);
		return reservationVehiculeDtoToUpdate;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		reservationVehiculeService.delete(id);
	}

	/** teste des methodes ***/

	/** Get METHODE 
	 * 
	 *  FONCTIONNE cherche tous les vehicules dispo et pas en
	 *  reservations entre deux dates
	 *  
	 *  **/
	@GetMapping("/searchReservations")
	public List<ReservationVehiculeDtoLight> searchReservations(@RequestParam(value = "vehiculeId") Integer vehiculeId,
			@RequestParam(value = "dateDepart") String dateDepart,
			@RequestParam(value = "dateRetour") String dateRetour) {

		List<ReservationVehicule> reservations = reservationVehiculeService.searchReserv(vehiculeId, dateDepart,
				dateRetour);
		List<ReservationVehiculeDtoLight> dtos = new ArrayList<>();

		reservations.forEach(m -> dtos.add(ReservationVehiculeDtoLightMapper.toDto(m)));
		return dtos;
	}

	/**
	 * put METHODE
	 * 
	 * FONCTIONNE
	 * 
	 **/
	@PostMapping("/createReservation")
	public ReservationVehiculeDtoEdit createReservation(
			@RequestBody ReservationVehiculeDtoEdit reservationVehiculeDtoEdit) {

		ReservationVehicule modelReser = ReservationVehiculeDtoEditMapper.toModel(reservationVehiculeDtoEdit);

		try {
			reservationVehiculeService.saveReserv(modelReser);
			return reservationVehiculeDtoEdit;
			
		//
		} catch (FunctionalException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());

			return null;
		}

	}

	/**
	 * 
	 * 
	 * 
	 * PUT MISE A JOUR
	 * MAJ FONCTIONNE
	 * 
	 **/
	@PutMapping("/MAJReservation/{id}")
	public ReservationVehiculeDtoEdit majReservation(
			@RequestBody @Valid ReservationVehiculeDtoEdit reservationVehiculeDtoEdit) {

		ReservationVehicule modelReser = ReservationVehiculeDtoEditMapper.toModel(reservationVehiculeDtoEdit);
		try {
			reservationVehiculeService.saveReserv(modelReser);
			return reservationVehiculeDtoEdit;

		} catch (FunctionalException e) {

			System.err.println(e.getMessage());

			return null;
		}

	}
}
