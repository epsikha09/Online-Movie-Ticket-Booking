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
import com.mts.model.Seat;

@SpringBootTest
class AddASeat extends AbstractTest {
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	@Autowired
	LoginController loginController; 

	@Test
	public void addASeat() throws Exception {
		loginController.loginUser("sunayana", "sunayana123");
		String uri = "/seats/seat";
		Seat st = new Seat("c12", "front", 25, null, null);
		String inputJson = super.mapToJson(st);
		System.out.println("=======================" + inputJson + "======================");
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		Seat seat = super.mapFromJson(content, Seat.class);
		assertEquals("c12", seat.getSeatNumber());
	}

}
