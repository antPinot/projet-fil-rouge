/**
 * 
 */
package fr.diginamic.GP3Covoiturage.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author antPinot
 *
 */

@Configuration
@EnableWebMvc
public class InitAndConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*")
				.allowedMethods("OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE")
				.allowedHeaders("Content-Type");
//				.allowedHeaders("Access-Control-Allow-Headers",
//						"X-Requested-With, Content-Type, Authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers",
//						"Access-Control-Allow-Origin");
	}
	
	

}
