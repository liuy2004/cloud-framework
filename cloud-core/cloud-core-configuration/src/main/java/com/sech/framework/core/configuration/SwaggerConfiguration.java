package com.sech.framework.core.configuration;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger API 文档配置
 *
 * @author sech.io
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        List<Parameter> operationParameters = new ArrayList<Parameter>();
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        parameterBuilder.name("Authorization").defaultValue(
                "Bearer 请求中获取heard中token参数|获取cookie中的x-access-token值").description("Bearer 令牌值")
                .modelRef(new ModelRef("string")).parameterType("header").required(true).build();
        operationParameters.add(parameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(
                RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).paths(
                PathSelectors.any()).build().globalOperationParameters(operationParameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(" API Online ").description(
                "https://github.com/sech-io/cloud-framework/wiki").termsOfServiceUrl(
                "https://github.com/sech-io/cloud-framework").contact(
                new Contact("sech", "https://github.com/sech-io/cloud-framework",
                        "ovrn@live.com")).version(ApiTag.TAG_DEFAULT).build();
    }
}
