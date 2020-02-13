package com.mycompany.falg.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.Block;
import com.mongodb.Function;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mycompany.falg.dto.CountryDTO;

@Component
public class AggregationDAOImpl implements AggregationDAO {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<CountryDTO> findFlagsByCountries(List<String> countries) {
		List<CountryDTO> retList = new ArrayList<>();
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase(mongoTemplate.getDb().getName());
		MongoCollection<Document> collection = database.getCollection("continents");

		AggregateIterable<Document> aggregate = collection.aggregate(Arrays.asList(
				Aggregates.project(Projections.fields(Projections.excludeId(), Projections.include("countries"))),
				Aggregates.unwind("$countries"), Aggregates.match(Filters.in("countries.name", countries))
		// Aggregates.group("$stars", Accumulators.sum("count", 1))
		));
		System.out.println("AAAAAAAAAA");
		aggregate.forEach((Block<Document>) System.out::println);
		Function<Document, CountryDTO> mapper = (doc) -> new CountryDTO(
				((Document) doc.get("countries")).get("name").toString(),
				((Document) doc.get("countries")).get("flag").toString());
		Function<CountryDTO, CountryDTO> mapper1 = d -> d;
		MongoCursor<Document> iterator = aggregate.iterator();
		while (iterator.hasNext()) {
			Document doc = iterator.next();
			retList.add(new CountryDTO(((Document) doc.get("countries")).get("name").toString(),
					((Document) doc.get("countries")).get("flag").toString()));
		}
		return retList;
	}

}
