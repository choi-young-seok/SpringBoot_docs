package kr.co.noel.study.docs;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.noel.study.controller.TestController;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@Slf4j
public class WebLayerTest {

	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private MockMvc mockMvc;
	
//	@Test // (1) : test hello world controller
//	public void shouldReturnDefaultMessage() throws Exception {
//	    this.mockMvc.perform(get("/"))
//        .andExpect(status().isOk())
//        .andExpect(content().string(containsString("Hello World")));
//	}
	
	@Test // (2) : generate rest docs with test case
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")))
                .andDo(document("index-example"));
    }
	
}
