/**
 * 
 */
package fr.diginamic.GP3Covoiturage.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author antPinot
 *
 */

@Configuration
public class InitAndConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry)  {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("OPTIONS","GET", "POST", "PUT", "PATCH", "DELETE")
        .allowedHeaders("Content-Type");
}
	
}
