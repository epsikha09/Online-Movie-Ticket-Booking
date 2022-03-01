package com.mts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mts.controller.LoginController;
import com.mts.model.Screen;
import com.mts.model.Theatre;

@SpringBootTest
class AddAScreen extends AbstractTest {
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	@Autowired
	LoginController loginController;



	@Test
	public void addAScreen() throws Exception {
		loginController.loginUser("sunayana", "sunayana123");
		String uri = "/screens/screen";
		Theatre th = new Theatre("Kabuki", "Tokyo", "Vidhya", "998990181", null, null);
		Screen sc = new Screen(th, null, "screen1", 4, 8);
		String inputJson = super.mapToJson(sc);
		System.out.println("=======================" + inputJson + "======================");
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Screen scr = super.mapFromJson(content, Screen.class);
		assertEquals("screen1", scr.getScreenName());
	}
	

}
