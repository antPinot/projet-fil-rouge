/**
 * 
 */
package fr.diginamic.GP3Covoiturage.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Classe qui fournit des méthodes utilitaires pour parser des 
 * LocalDate (Date de création ou date de naissance) et des LocalDateTime
 * (Date de début/fin de réservation de véhicule ou date de départ/arrivée d'un
 * covoiturage) et réciproquement.
 * 
 * @author antPinot
 *
 */
public class DateUtils {

	/**
	 * @param localDate LocalDate
	 * @return String
	 */
	public static String localDateToString(LocalDate localDate) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY", Locale.FRANCE);
		return dtf.format(localDate);
	}
	
	/**
	 * @param localDate LocalDateTime
	 * @return String 
	 */
	public static String localDateTimeToString(LocalDateTime localDate) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm", Locale.FRANCE);
		return dtf.format(localDate);
	}
	
	/**
	 * @param formattedLocalDate
	 * @return
	 */
	public static LocalDate stringToLocalDate(String formattedLocalDate) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.FRANCE);
		return LocalDate.parse(formattedLocalDate, dtf);
	}
	
	/**
	 * @param formattedLocalDateTime
	 * @return
	 */
	public static LocalDateTime stringToLocalDateTime(String formattedLocalDateTime) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", Locale.FRANCE);
		return LocalDateTime.parse(formattedLocalDateTime, dtf);
	}

}
