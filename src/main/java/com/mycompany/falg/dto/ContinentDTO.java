package com.mycompany.falg.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class ContinentDTO.
 */
@JsonInclude(Include.NON_NULL)
public class ContinentDTO {

	/** The continent. */
	private String continent;
	
	/** The Id. */
	private String Id;
	
	/** The contries. */
	private List<CountryDTO> contries;

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
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return Id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		Id = id;
	}

	/**
	 * Gets the contries.
	 *
	 * @return the contries
	 */
	public List<CountryDTO> getContries() {
		return contries;
	}

	/**
	 * Sets the contries.
	 *
	 * @param contries the new contries
	 */
	public void setContries(List<CountryDTO> contries) {
		this.contries = contries;
	}

	/**
	 * Instantiates a new continent DTO.
	 *
	 * @param continent the continent
	 */
	public ContinentDTO(String continent) {
		super();
		this.continent = continent;
	}

	/**
	 * Instantiates a new continent DTO.
	 */
	public ContinentDTO() {
		super();
	}

}
