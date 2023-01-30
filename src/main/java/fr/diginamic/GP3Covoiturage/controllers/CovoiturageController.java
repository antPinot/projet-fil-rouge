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

import fr.diginamic.GP3Covoiturage.dto.CovoiturageDto;
import fr.diginamic.GP3Covoiturage.dto.CovoiturageDtoMapper;
import fr.diginamic.GP3Covoiturage.models.Covoiturage;
import fr.diginamic.GP3Covoiturage.services.CovoiturageService;
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
	public Covoiturage findOne(@PathVariable("id") Integer id) {
		return this.covoiturageService.findById(null);
	}

	/**
	 * @method return list
	 */
	@GetMapping()
	public List<Covoiturage> getListCovoiturages() {
		return covoiturageService.findAll();
	}

	/**
	 * @method create
	 */
	@PostMapping()
	public CovoiturageDto createCovoiturage(@RequestBody @Valid CovoiturageDto createCovoiturage) {

		Covoiturage modelCovoit = CovoiturageDtoMapper.toModel(createCovoiturage);
		covoiturageService.create(modelCovoit);
		return createCovoiturage;
	}

	/**
	 * @method update
	 */
	@PutMapping("/{id}")
	public CovoiturageDto updateCovoiturage(@PathVariable("id") Integer id, @Valid CovoiturageDto updateCovoiturage) {
		if (!id.equals(updateCovoiturage.getId())) {

			throw new RuntimeException("probleme : covoiturage existe pas");
		}

		Covoiturage modelCovoit = CovoiturageDtoMapper.toModel(updateCovoiturage);
		covoiturageService.update(modelCovoit);
		return updateCovoiturage;
	}

	/**
	 * @method delete
	 */
	@DeleteMapping("/{id}")
	public void deleteCovoiturage(@PathVariable("id") Integer id, @RequestBody @Valid Covoiturage deleteCovoiturage) {
		if (!id.equals(deleteCovoiturage.getId())) {
			throw new RuntimeException("Erreur : Covoiturage pas present en bdd");
		}
		this.covoiturageService.delete(id);

	}

}
