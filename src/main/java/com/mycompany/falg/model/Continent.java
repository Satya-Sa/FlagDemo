package com.mycompany.falg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Class Continent.
 */
@Document("continents")
public class Continent {

	/** The id. */
	@Id
	private String _id;

	/** The continent. */
	private String continent;

	/** The countries. */
	private Country[] countries;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String get_id() {
		return _id;
	}

	/**
	 * Sets the id.
	 *
	 * @param _id the new id
	 */
	public void set_id(String _id) {
		this._id = _id;
	}

	/**
	 * Gets the continent.
	 *
	 * @return the continent
	 */
	public String getContinent() {
		return continent;
	}

	/**
	 * Sets the continent.
	 *
	 * @param continent the new continent
	 */
	public void setContinent(String continent) {
		this.continent = continent;
	}

	/**
	 * Gets the countries.
	 *
	 * @return the countries
	 */
	public Country[] getCountries() {
		return countries;
	}

	/**
	 * Sets the countries.
	 *
	 * @param countries the new countries
	 */
	public void setCountries(Country[] countries) {
		this.countries = countries;
	}

}
