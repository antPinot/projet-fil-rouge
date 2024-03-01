/**
 * 
 */
package fr.diginamic.GP3Covoiturage.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author antPinot
 * 
 * Enumération listant les catégories existantes pour les véhicules de société
 *
 */

public enum Categorie {

	MICRO_URBAINES("Micro-urbaines"), MINI_CITADINES("Mini-citadines"),
	CITADINES_POLYVALENTES("Citadines polyvalentes"), COMPACTES("Compactes"), BERLINES_TAILLE_S("Berlines Taille S"),
	BERLINES_TAILLE_M("Berlines Taille M"), BERLINES_TAILLE_L("Berlines Taille L"),
	SUV_TOUT_TERRAINS_PICK_UP("SUV tout terrains/pick-up");

	/** Libellé de la catégorie*/
	private String libelle;

	/**
	 * Constructeur
	 * 
	 * @param libelle
	 */
	private Categorie(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Getter pour l'attribut libelle
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Setter pour l'attribut libelle
	 * 
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public static Categorie valueOfName (String name) {
		Categorie[] categorie = values();
		for(Categorie c: categorie) {
			if (c.getLibelle().equals(name)) {
				return c;
			}
		}
		return null;
	}
	
	public static String nameOfValue (String value) {
		Categorie[] categorie = values();
		for(Categorie c: categorie) {
			if (c.name().equals(value)) {
				return c.getLibelle();
			}
		}
		return null;
	}
	
	public static List<String> getAllCategoriesLibelle(){
		List<String> allCategoriesLibelle = new ArrayList<>();
		Categorie[] categories = values();
		for(Categorie c : categories) {
			allCategoriesLibelle.add(c.getLibelle());
		}
		return allCategoriesLibelle;
	}
	
}
