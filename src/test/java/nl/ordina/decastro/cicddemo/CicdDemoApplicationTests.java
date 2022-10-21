package nl.ordina.decastro.cicddemo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CicdDemoApplication.class)
@WebAppConfiguration
class CicdDemoApplicationTests {
	@Autowired
	private WebApplicationContext wac;

	@Test
	void sayHello() throws Exception {
		String uri = "/greet?name=jason";
		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.TEXT_PLAIN)).andReturn();
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals(200, status);
		Assert.assertEquals("Hi there jason, what can I do for you?", content);
	}

}
