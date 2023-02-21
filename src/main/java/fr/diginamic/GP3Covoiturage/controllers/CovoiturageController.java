package fr.diginamic.GP3Covoiturage.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.GP3Covoiturage.dto.CovoiturageDto;
import fr.diginamic.GP3Covoiturage.dto.CovoiturageDtoMapper;
import fr.diginamic.GP3Covoiturage.dto.dtoEdit.CovoiturageDtoEdit;
import fr.diginamic.GP3Covoiturage.dto.dtoEdit.CovoiturageDtoEditMapper;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.CovoiturageDtoLight;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.CovoiturageDtoLightMapper;
import fr.diginamic.GP3Covoiturage.models.Collaborateur;
import fr.diginamic.GP3Covoiturage.models.Covoiturage;
import fr.diginamic.GP3Covoiturage.models.VehiculePersonnel;
import fr.diginamic.GP3Covoiturage.services.CovoiturageService;
import fr.diginamic.GP3Covoiturage.services.VehiculePersonnelService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

/**
 * @author Fekhreddine
 */

@RestController
@RequestMapping("/rest/covoiturage")
public class CovoiturageController {

	@Autowired
	CovoiturageService covoiturageService;

	/**
	 * @method return a id
	 */
	@GetMapping("/{id}")
	public CovoiturageDtoLight findOne(@PathVariable("id") Integer id) {
		return CovoiturageDtoLightMapper.toDto(covoiturageService.findById(id));
	}

	/**
	 * @method return list
	 */
	@GetMapping()
	public List<CovoiturageDtoLight> getListCovoiturages() {
		List<Covoiturage> models = covoiturageService.findAll();
		List<CovoiturageDtoLight> dtos = new ArrayList<>();
		models.forEach(m -> dtos.add(CovoiturageDtoLightMapper.toDto(m)));
		return dtos;
	}

	@GetMapping("/")
	public List<CovoiturageDtoLight> readByCollaborateur(@RequestParam Integer collaborateurId,
			@RequestParam String state) {
			List<Covoiturage> models = covoiturageService.findEnCoursByCollaborateurs(collaborateurId, state);
			List<CovoiturageDtoLight> dtos = new ArrayList<>();
			models.forEach(m -> dtos.add(CovoiturageDtoLightMapper.toDto(m)));
			return dtos;
	}

	@GetMapping("/criteres")
	public List<CovoiturageDtoLight> readByCriteres(@RequestParam Integer collaborateurId, @RequestParam(defaultValue = "none") String adresseDepart,
			@RequestParam(defaultValue = "none") String adresseArrivee,
			@RequestParam(defaultValue = "none") String dateDepart) {
			List<Covoiturage> models = covoiturageService.findByCriteres(collaborateurId, adresseDepart, adresseArrivee, dateDepart);
			List<CovoiturageDtoLight> dtos = new ArrayList<>();
			models.forEach(m -> dtos.add(CovoiturageDtoLightMapper.toDto(m)));
			return dtos;
	}

	/**
	 * @throws FunctionalException
	 * @method create
	 */
	@PostMapping()
	@Transactional
	public CovoiturageDtoEdit createCovoiturage(@RequestBody @Valid CovoiturageDtoEdit createCovoiturage) {

		Covoiturage modelCovoit = CovoiturageDtoEditMapper.toModel(createCovoiturage);
		covoiturageService.create(modelCovoit);
		return createCovoiturage;
	}

	/**
	 * @method update
	 */
	@PutMapping("/{id}")
	public CovoiturageDtoEdit updateCovoiturage(@PathVariable("id") Integer id,
			@RequestBody @Valid CovoiturageDtoEdit updateCovoiturage) {
		if (!id.equals(updateCovoiturage.getId())) {

			throw new RuntimeException("probleme : covoiturage existe pas");
		}

		Covoiturage modelCovoit = CovoiturageDtoEditMapper.toModel(updateCovoiturage);
		covoiturageService.update(modelCovoit);
		return updateCovoiturage;
	}
	
	@PutMapping("/reserver/{id}/{collaborateurId}")
	public CovoiturageDtoLight reserverCovoiturage(@PathVariable("id") Integer id, @PathVariable("collaborateurId") Integer collaborateurId) {
		covoiturageService.reserverCovoiturage(id, collaborateurId);
		return CovoiturageDtoLightMapper.toDto(covoiturageService.findById(id));
	}

	@PutMapping("/annuler-participation/{id}/{collaborateurId}")
	public CovoiturageDtoLight annulerParticipation(@PathVariable("id") Integer id, @PathVariable("collaborateurId") Integer collaborateurId) {
		covoiturageService.annulerParticipation(id, collaborateurId);
		return CovoiturageDtoLightMapper.toDto(covoiturageService.findById(id));
	}
	
	/**
	 * @method delete
	 */
	@DeleteMapping("/{id}")
	public void deleteCovoiturage(@PathVariable("id") Integer id) {
		covoiturageService.delete(id);

	}
	
	@GetMapping("/annonces/{id}")
	public List<CovoiturageDtoLight> readByOrganisateur(@PathVariable("id") Integer idOrganisateur, @RequestParam String statut) {
		List<Covoiturage> listCovoit = covoiturageService.findCovoitByOrganisateur(idOrganisateur, statut);
		List<CovoiturageDtoLight> listCovoitDto = new ArrayList<>();
		for(int i=0; i< listCovoit.size();i++) {
			listCovoitDto.add(CovoiturageDtoLightMapper.toDto(listCovoit.get(i)));
		};
		return listCovoitDto;
	}
	
	@DeleteMapping("/annuler-covoit/{id}/{organisateur}")
	public void annulerCovoiturage(@PathVariable("id") Integer id, @PathVariable("organisateur") Integer idOrganisateur) {
		covoiturageService.annulerCovoit(id, idOrganisateur);

	}

}
