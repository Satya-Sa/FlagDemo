package com.mycompany.falg;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.mycompany.falg.controller.FlagApplicationController;
import com.mycompany.falg.dto.CountryDTO;

@SpringBootTest
@AutoConfigureMockMvc
class FlagDemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private FlagApplicationController flagApplicationController;

	@Test
	public void contexLoads() throws Exception {
		assertThat(flagApplicationController).isNotNull();
	}

	@Test
	void getContinents() throws Exception {
		this.mockMvc.perform(get("/getContinents")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("America")));
	}

	@Test
	void getCountries() throws Exception {
		ResponseEntity<List<CountryDTO>> allContinents = flagApplicationController.getCountries("America");
		this.mockMvc.perform(get("/getCountries/America")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("USA")));
	}

}
