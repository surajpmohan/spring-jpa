package com.spm.jpa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spm.jpa.entity.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
public class StudentApplicationTests {

	@Autowired
	MockMvc mvc;

	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void contextLoads() {
	}

	@Test
	public void testPost() throws Exception {
		Student student = Student.builder().firstName("Suraj").lastName("pm").build();
		MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/student")
				.contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(student)))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		System.out.println("Response: " + result.getResponse().getContentAsString());
		Student actual = mapper.readValue(result.getResponse().getContentAsString(), Student.class);
		student.setStudentId(actual.getStudentId());
		Assert.assertEquals(student, actual);
	}

}
