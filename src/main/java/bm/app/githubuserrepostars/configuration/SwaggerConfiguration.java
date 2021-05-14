package bm.app.githubuserrepostars.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket docks(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("bm.app.githubuserrepostars"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "GitHub User Repo Stars",
                "An API for retrieving data about a github's user's repositories and counting the stars they received. ",
                "1.1",
                "Free to use",
                new springfox.documentation.service.Contact("Bartosz Mierzwinski", "https://github.com/Bartosz76", "mierzwinski.b@gmail.com"),
                "API License",
                "https://github.com/Bartosz76",
                Collections.emptyList());
    }
}
