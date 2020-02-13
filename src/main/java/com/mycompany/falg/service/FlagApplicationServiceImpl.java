package com.mycompany.falg.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.falg.dao.ContinentDAO;
import com.mycompany.falg.dto.ContinentDTO;
import com.mycompany.falg.dto.CountryDTO;
import com.mycompany.falg.exception.DataNotFoundException;
import com.mycompany.falg.model.Continent;

/**
 * The Class FlagApplicationServiceImpl.
 */
@Service
public class FlagApplicationServiceImpl implements FlagApplicationService {

	/** The continent DAO. */
	@Autowired
	ContinentDAO continentDAO;

	/**
	 * Gets the all continents.
	 *
	 * @return the all continents
	 */
	public List<ContinentDTO> getAllContinents() {
		return continentDAO.findContinent().stream().map(continent -> new ContinentDTO(continent.getContinent()))
				.collect(Collectors.toList());
	}

	/**
	 * Gets the countries by continent.
	 *
	 * @param continentName the continent name
	 * @return the countries by continent
	 * @throws DataNotFoundException the data not found exception
	 */
	public List<CountryDTO> getCountriesByContinent(String continentName) throws DataNotFoundException {
		Continent continent = continentDAO.findCountriesByContinent(continentName);
		if (continent == null) {
			throw new DataNotFoundException("Data not found for " + continentName);
		}
		return Arrays.stream(continent.getCountries())
				.map(country -> new CountryDTO(country.getName(), country.getFlag())).collect(Collectors.toList());
	}

	/**
	 * Gets the flags by countries.
	 *
	 * @param countries the countries
	 * @return the flags by countries
	 * @throws DataNotFoundException the data not found exception
	 */
	public List<CountryDTO> getFlagsByCountries(List<String> countries) throws DataNotFoundException {

		return continentDAO.findFlagsByCountries(countries);
	}

}
