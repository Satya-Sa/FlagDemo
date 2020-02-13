package com.mycompany.falg.service;

import java.util.List;

import com.mycompany.falg.dto.ContinentDTO;
import com.mycompany.falg.dto.CountryDTO;
import com.mycompany.falg.exception.DataNotFoundException;

/**
 * The Interface FlagApplicationService.
 */
public interface FlagApplicationService {

	/**
	 * Gets the all continents.
	 *
	 * @return the all continents
	 */
	List<ContinentDTO> getAllContinents();

	/**
	 * Gets the countries by continent.
	 *
	 * @param continentName the continent name
	 * @return the countries by continent
	 * @throws DataNotFoundException the data not found exception
	 */
	List<CountryDTO> getCountriesByContinent(String continentName) throws DataNotFoundException;

	/**
	 * Gets the flags by countries.
	 *
	 * @param countries the countries
	 * @return the flags by countries
	 * @throws DataNotFoundException the data not found exception
	 */
	List<CountryDTO> getFlagsByCountries(List<String> countries)  throws DataNotFoundException;;

}
