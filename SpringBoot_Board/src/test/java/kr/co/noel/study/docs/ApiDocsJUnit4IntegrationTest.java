package kr.co.noel.study.docs;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiDocsJUnit4IntegrationTest {

	@Rule
	public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");
	
	@Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
          .apply(documentationConfiguration(this.restDocumentation))
          .build();
    }
    
//    @Before
//    public void setUp() {
//
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
//            .apply(documentationConfiguration(this.restDocumentation))
//            .alwaysDo(document("{method-name}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))
//            .build();
//    }
}
