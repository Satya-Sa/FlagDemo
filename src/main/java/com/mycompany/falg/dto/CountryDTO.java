package com.mycompany.falg.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class CountryDTO.
 */
@JsonInclude(Include.NON_NULL)

public class CountryDTO {

	/** The name. */
	private String name;
	
	/** The flag. */
	private String flag;

	/**
	 * Instantiates a new country DTO.
	 *
	 * @param name the name
	 * @param flag the flag
	 */
	public CountryDTO(String name, String flag) {
		super();
		this.name = name;
		this.flag = flag;
	}

	/**
	 * Instantiates a new country DTO.
	 */
	public CountryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the flag.
	 *
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * Sets the flag.
	 *
	 * @param flag the new flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

}
