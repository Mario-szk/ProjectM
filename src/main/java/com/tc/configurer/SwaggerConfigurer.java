package com.tc.configurer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 * @author robosen
 */
@Configuration
@EnableSwagger2
public class SwaggerConfigurer  {
	@Value("${swagger2.host}")
	private String swaggerHost;

	@Value("${server.port}")
	private String port;

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.host(swaggerHost+":"+port)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.tc.web.controller"))

				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("ProjectM 价值数据中心云平台")
				.description("ProjectM 价值数据中心云平台-Restful Api")
				//.termsOfServiceUrl("http://49.235.60.22/9999")
				.version("1.0")
				.build();
	}
}