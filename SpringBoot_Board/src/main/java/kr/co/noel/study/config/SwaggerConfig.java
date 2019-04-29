package kr.co.noel.study.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author 최용석
 * @since 2019-04-26
 * {@link #https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api} 
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
//				.apis(RequestHandlerSelectors.any()) 										// 전체 package를 api docs로 추출
//				.paths(PathSelectors.any())													// 해당 package경로의 전체 요청을 api docs로 추출
				.apis(RequestHandlerSelectors.basePackage("kr.co.noel.study.controller")) 	// 지정한 특정 pacakge 경로만 apidocs로 추출
				.paths(PathSelectors.ant("/board"))													// 해당 패키지의 특정 요청을 api docs로 추출 -> any : 전체요청 추출, ants("패턴") : 패턴에 해당하는 요청만 추출 
				.build()							
				.apiInfo(this.apiInfo());										// swagger main 화면 info customizing 
//				.useDefaultResponseMessages(false)											// Swagger2 기본 HTTP 응답 메세지 사용 해제
//				.globalResponseMessage(RequestMethod.GET, responseMessageStatus)			// get(조회) 요청의 응답 메세지를 재정의
//				.globalResponseMessage(RequestMethod.POST, responseMessageStatus)			// post(입력) 요청의 응답 메세지를 재정의
//				.globalResponseMessage(RequestMethod.PUT, responseMessageStatus);			// put(수정) 요청의 응답 메세지를 재정의
//				.globalResponseMessage(RequestMethod.PATCH, responseMessageStatus)			// patch(미사용 권장) 요청의 응답 메세지를 재정의
//				.globalResponseMessage(RequestMethod.DELETE, responseMessageStatus);		// delete 요청의 응답 메세지를 재정의
	}
	
	private ApiInfo apiInfo() {
	    ApiInfo apiInfo = new ApiInfo(
	      "Shop API",						// API Docs title
	      "Additional Link",		// description
	      "V_0.01",							// API version
	      "termsOfServiceUrl?",				// termsOfServiceUrl
	      new Contact("코어개발팀", "개발팀 홈피", "개발팀 이메일"),						// contact link
	      "추가 링크_1",				// license
	      "API license URL",		// licenseUrl
	      new ArrayList<VendorExtension>());				
				
	    return apiInfo;
	}
	
	// 응답 메세지 커스터마이징
//	ArrayList responseMessageStatus = new ArrayList(
//			(Collection) new ResponseMessageBuilder().code(200).message("success").build(),
//    		new ResponseMessageBuilder().code(200).message("Success").responseModel(new ModelRef("Success")).build(),
//			(Collection) new ResponseMessageBuilder().code(404).message("error").build()
//			(Collection) new ResponseMessageBuilder().code(400).message("success").build(),
//			(Collection) new ResponseMessageBuilder().code(401).message("success").build(),
//			(Collection) new ResponseMessageBuilder().code(403).message("success").build(),
//			(Collection) new ResponseMessageBuilder().code(404).message("success").build(),
//			(Collection) new ResponseMessageBuilder().code(500).message("success").build(),
//			(Collection) new ResponseMessageBuilder().code(502).message("success").build(),
//			(Collection) new ResponseMessageBuilder().code(503).message("success").build()
//        );
}
