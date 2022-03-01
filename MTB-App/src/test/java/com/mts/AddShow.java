package com.mts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mts.controller.LoginController;
import com.mts.model.Screen;
import com.mts.model.Show;
import com.mts.model.Theatre;

@SpringBootTest
class AddShow extends AbstractTest {
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	@Autowired
	LoginController loginController;


	@Test
	public void addShow() throws Exception {
		loginController.loginUser("sunayana", "sunayana123");
		String uri = "/shows/show";
		Theatre th = new Theatre("Kabuki", "Tokyo", "Vidhya", "998990181", null, null);
		Screen sc = new Screen(th, null, "screen1", 4, 8);
		Show sh = new Show(LocalDateTime.of(2020, 10, 29, 7, 4, 2, 0), LocalDateTime.of(2020, 10, 29, 9, 4, 2, 0),
				"MorningShow", null, sc, th, null, LocalDate.of(2021, 04, 28));
		String inputJson = super.mapToJson(sh);
		System.out.println("=======================" + inputJson + "======================");
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		Show sho = super.mapFromJson(content, Show.class);
		assertEquals("MorningShow", sho.getShowName());
	}

	
}
