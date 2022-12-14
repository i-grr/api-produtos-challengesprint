package br.com.fiap.challengesprint.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private static final String API_BASE_PACKAGE = "br.com.fiap";
    private static final String API_TITLE = "API de Produtos";
    private static final String API_DESCRIPTION = "API REST para o controle de produtos";
    private static final String API_VERSION = "1.0.0";
    private static final String TEAM_NAME = "Kodalgrr";
    private static final String GITHUB_PROJECT = "https://github.com/i-grr/api-produtos-challengesprint";
    private static final String TEAM_EMAIL = "time.kodal@gmail.com";

    @Bean
    public Docket produtosApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage(API_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(buildApiInfo());
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version(API_VERSION)
                .contact(new Contact(TEAM_NAME, GITHUB_PROJECT, TEAM_EMAIL))
                .build();
    }

}
