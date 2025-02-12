package com.desafiouno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return regex("/periodos.*");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("DESAFIO_UNO API SWAGGER")
				.description("Swagger API")
				.termsOfServiceUrl("http://www.previred.com")
				.licenseUrl("https://www.swagger.io/").version("2.9.2").build();
	}
}