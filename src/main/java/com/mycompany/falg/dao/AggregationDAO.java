package com.mycompany.falg.dao;

import java.util.List;

import com.mycompany.falg.dto.CountryDTO;

public interface AggregationDAO {

	public List<CountryDTO> findFlagsByCountries(List<String> countries);

}
