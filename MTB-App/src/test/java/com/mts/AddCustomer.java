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
import com.mts.model.Customer;

@SpringBootTest
class AddCustomer extends AbstractTest {
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	@Autowired
	LoginController loginController; 

	@Test
	public void addCustomer() throws Exception {
		String uri = "/customer/customer";
		Customer cu = new Customer("Surya", "Anantapur", "7569369939", "surya@gmail.com", "bunny");
		String inputJson = super.mapToJson(cu);
		System.out.println("=======================" + inputJson + "======================");
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(404, status);
	}

}
