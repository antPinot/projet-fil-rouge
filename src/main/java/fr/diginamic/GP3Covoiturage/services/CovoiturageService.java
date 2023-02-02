package fr.diginamic.GP3Covoiturage.services;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.GP3Covoiturage.dto.CovoiturageDto;
import fr.diginamic.GP3Covoiturage.dto.CovoiturageDtoMapper;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.AdresseDtoLight;
import fr.diginamic.GP3Covoiturage.dto.dtoLight.AdresseDtoLightMapper;
import fr.diginamic.GP3Covoiturage.models.Adresse;
import fr.diginamic.GP3Covoiturage.models.Covoiturage;
import fr.diginamic.GP3Covoiturage.repositories.CovoiturageRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

/**
 * @author Fekhreddine
 */

@Service
public class CovoiturageService {

	@Autowired
	CovoiturageRepository covoiturageRepository;
	
	@Autowired
	AdresseService adresseService;
	

	/**
	 * @method create()
	 */

	public Covoiturage create(@Valid Covoiturage createCovoiturage) {

		if (createCovoiturage.getId() != null) {
			throw new RuntimeException("erreur : id est deja present");
		}
		
		// Attention à l'ordre des paramètres de la méthode findExistingAdresse
		Adresse adresseDepart = createCovoiturage.getAdresseDepart();
		List<Adresse> query = adresseService.findExistingAdresse(adresseDepart.getNumero(), adresseDepart.getComplementNumero(), adresseDepart.getVoie(), adresseDepart.getCodePostal(), adresseDepart.getDepartement(), adresseDepart.getPays(), adresseDepart.getVille());
		
		if (query.isEmpty()) {
			adresseService.create(adresseDepart);
			createCovoiturage.setAdresseDepart(adresseDepart);
		}else {
			createCovoiturage.setAdresseDepart(query.get(0));
		}
		
		return this.covoiturageRepository.save(createCovoiturage);
	}

	
	
	/**
	 * @method update()
	 */
	public Covoiturage update(@Valid Covoiturage updateCovoiturage) {

		if (updateCovoiturage.getId() == null) {

			throw new RuntimeException("erreur : le coivoiturage n'est pas encore créer");
		}

	
		return this.covoiturageRepository.save(updateCovoiturage);
	}

	/**
	 * @method findAll()
	 */
	public List<Covoiturage> findAll() {

		return covoiturageRepository.findAll();
	}

	/**
	 * @method findById()
	 */
	public Covoiturage findById(Integer id) {
		return this.covoiturageRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	/**
	 * @method delete()
	 */
	public void delete(Integer id) {

		if (id == null) {
			throw new RuntimeException("erreur : id covoiturage pas present");
		}
		this.covoiturageRepository.deleteById(id);
	}

}
