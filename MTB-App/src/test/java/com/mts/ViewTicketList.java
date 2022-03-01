package com.mts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mts.controller.LoginController;
import com.mts.model.Ticket;

@SpringBootTest
class ViewTicketList extends AbstractTest {
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	@Autowired
	LoginController loginController;

	@Test
	public void viewTicketList() throws Exception {
		String uri = "/tickets/findall";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Ticket tk[] = super.mapFromJson(content, Ticket[].class);
		assertEquals(2, tk[tk.length - 1].getNoOfSeats());
	}
}
