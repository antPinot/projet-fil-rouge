package fr.diginamic.GP3Covoiturage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import fr.diginamic.GP3Covoiturage.models.Covoiturage;
import fr.diginamic.GP3Covoiturage.repositories.CovoiturageRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

/**
 * @author Fekhreddine
 */
public class CovoiturageService {

	
	@Autowired
	CovoiturageRepository covoiturageRepository;
	
	
	/**
	 * @method services de CRUD basique
	 */


	public Covoiturage create(@Valid Covoiturage createCovoiturage) {

		if (createCovoiturage.getId() != null) {
			throw new RuntimeException("erreur : id est deja present");
		}
		return this.covoiturageRepository.save(createCovoiturage);
	}

	public Covoiturage update(@Valid Covoiturage updateCovoiturage) {

		if (updateCovoiturage.getId() == null) {

			throw new RuntimeException("erreur : le coivoiturage n'est pas encore créer");
		}
		return this.covoiturageRepository.save(updateCovoiturage);
	}

	public List<Covoiturage> findAll() {
		return covoiturageRepository.findAll();
	}

	public Covoiturage findById(Integer id) {
		return this.covoiturageRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	public void delete(Integer id) {

		if (id == null) {
			throw new RuntimeException("erreur : id covoiturage pas present");
		}
		this.covoiturageRepository.deleteById(id);
	}

}
