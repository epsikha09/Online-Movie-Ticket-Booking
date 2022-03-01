package com.mts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mts.controller.LoginController;
import com.mts.model.Movie;

@SpringBootTest
class AddMovie extends AbstractTest {
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	@Autowired
	LoginController loginController;
 

	@Test
	public void addMovie() throws Exception {
		loginController.loginUser("sunayana", "sunayana123");
		String uri = "/movies/movie";
		Movie mov = new Movie("Avengers", "scifi", "04", "English", "Good", uri, LocalDate.of(2007, 12, 03), null);
		String inputJson = super.mapToJson(mov);
		System.out.println("=======================" + inputJson + "======================");
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		Movie Mv = super.mapFromJson(content, Movie.class);
		assertEquals("Avengers", Mv.getMovieName());

	}

}
