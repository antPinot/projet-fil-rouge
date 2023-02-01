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
import fr.diginamic.GP3Covoiturage.dto.dtoEdit.CovoiturageDtoEdit;
import fr.diginamic.GP3Covoiturage.dto.dtoEdit.CovoiturageDtoEditMapper;
import fr.diginamic.GP3Covoiturage.models.Covoiturage;
import fr.diginamic.GP3Covoiturage.services.CovoiturageService;
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
	public CovoiturageDto findOne(@PathVariable("id") Integer id) {
		return CovoiturageDtoMapper.toDto(covoiturageService.findById(id));
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
	public CovoiturageDtoEdit updateCovoiturage(@PathVariable("id") Integer id, @Valid CovoiturageDtoEdit updateCovoiturage) {
		if (!id.equals(updateCovoiturage.getId())) {

			throw new RuntimeException("probleme : covoiturage existe pas");
		}

		Covoiturage modelCovoit = CovoiturageDtoEditMapper.toModel(updateCovoiturage);
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
