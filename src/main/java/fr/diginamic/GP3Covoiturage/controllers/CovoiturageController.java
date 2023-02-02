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
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.GP3Covoiturage.dto.CovoiturageDto;
import fr.diginamic.GP3Covoiturage.dto.CovoiturageDtoMapper;
import fr.diginamic.GP3Covoiturage.dto.dtoEdit.CovoiturageDtoEdit;
import fr.diginamic.GP3Covoiturage.dto.dtoEdit.CovoiturageDtoEditMapper;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.CovoiturageDtoLight;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.CovoiturageDtoLightMapper;
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
	public CovoiturageDtoEdit updateCovoiturage(@PathVariable("id") Integer id,@RequestBody @Valid CovoiturageDtoEdit updateCovoiturage) {
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
	public void deleteCovoiturage(@PathVariable("id") Integer id) {
		covoiturageService.delete(id);

	}

}
