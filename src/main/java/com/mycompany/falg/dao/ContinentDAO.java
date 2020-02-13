package com.mycompany.falg.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mycompany.falg.model.Continent;

/**
 * The Interface ContinentDAO.
 */
public interface ContinentDAO extends MongoRepository<Continent, String>, AggregationDAO {

	/**
	 * Find continent.
	 *
	 * @return the list
	 */
	@Query(value = "{}", fields = "{ _id:0, countries:0  }")
	public List<Continent> findContinent();

	/**
	 * Find countries by continent.
	 *
	 * @param continent the continent
	 * @return the continent
	 */
	@Query(value = "{continent: ?0}", fields = "{ _id:0, continent:0  }")
	public Continent findCountriesByContinent(String continent);

	/**
	 * Find flags by countries.
	 *
	 * @param countries the countries
	 * @return the list
	 */
//	@Query(value = "{'countries.name': {$in: ?0}}", fields = "{ _id:0, continent:0  }")
	//public List<Continent> findFlagsByCountries(List<String> countries);

}
