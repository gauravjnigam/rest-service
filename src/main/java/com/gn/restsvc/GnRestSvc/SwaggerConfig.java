package com.gn.restsvc.GnRestSvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.produces(getProduces())
				.consumes(getProduces());
	}

	private Set<String> getProduces() {
		return new HashSet<>(Arrays.asList("application/json","application/xml"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("GnRestApi - a rest api examples", "rest api learning examples", "1.0", "tos", getContact(),
				"tos", "api/tos", Collections.emptyList());
	}

	private Contact getContact() {
		return new Contact("gnigam", "www.gauravjnigam.com", "gauravjnigam@gmail.com");
	}
}
