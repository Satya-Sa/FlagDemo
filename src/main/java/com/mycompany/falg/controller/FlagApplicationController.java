package com.mycompany.falg.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mycompany.falg.dto.ContinentDTO;
import com.mycompany.falg.dto.CountryDTO;
import com.mycompany.falg.exception.DataNotFoundException;
import com.mycompany.falg.service.FlagApplicationService;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@RestController("/api")
@EnableSwagger2

public class FlagApplicationController {

	final Logger logger = LoggerFactory.getLogger(FlagApplicationController.class);

	/**
	 * Swagger Config.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket application1Api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.mycompany.falg.controller")).paths(PathSelectors.any())
				.build();
	}

	/** The application service. */
	@Autowired
	private FlagApplicationService applicationService;

	/**
	 * Gets the all continents.
	 *
	 * @return the all continents
	 */
	@GetMapping("/getContinents")
	public ResponseEntity<List<ContinentDTO>> getAllContinents() {
		logger.info("Entered in getContinents()");
		return new ResponseEntity<List<ContinentDTO>>(applicationService.getAllContinents(), HttpStatus.OK);
	}

	/**
	 * Gets the countries.
	 *
	 * @param continent the continent
	 * @return the countries
	 */
	@GetMapping("/getCountries/{continent}")
	public ResponseEntity<List<CountryDTO>> getCountries(@PathVariable String continent) {
		try {
			return new ResponseEntity<List<CountryDTO>>(applicationService.getCountriesByContinent(continent),
					HttpStatus.OK);
		} catch (DataNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

	/**
	 * Gets the flags.
	 *
	 * @param countries the countries
	 * @return the flags
	 */
	@GetMapping("/getFlags")
	public ResponseEntity<List<CountryDTO>> getFlags(@RequestParam String countries) {
		try {
			return new ResponseEntity<List<CountryDTO>>(
					applicationService.getFlagsByCountries(Arrays.asList(countries.split(","))), HttpStatus.OK);
		} catch (DataNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

}
