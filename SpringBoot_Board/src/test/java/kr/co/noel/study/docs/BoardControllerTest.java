package kr.co.noel.study.docs;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@Slf4j
public class BoardControllerTest {

//	@Rule
//	public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();
//	
//	@Autowired
//	private WebApplicationContext context;
//	private MockMvc mockMvc;
//	private RestDocumentationResultHandler document;
//	
//	@Before
//    public void setUp() {
//        this.document = MockMvcRestDocumentation.document(
//                "{class-name}/{method-name}" 
////                , preprocessResponse(prettyPrint())
//        );
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
//                .apply(documentationConfiguration(this.restDocumentation))
//                .alwaysDo(document)
//                .build();
//    }
	
}
