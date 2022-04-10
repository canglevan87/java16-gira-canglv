package cybersoft.javabackend.java16giracanglv.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securityContexts(List.of(getSecurityContext()))
                .securitySchemes(List.of(getSecurityScheme()))
                .select().apis(RequestHandlerSelectors.basePackage("cybersoft.javabackend.java16giracanglv")).build().apiInfo(new ApiInfoBuilder()
                        .title("Gira App Java Backend").version("1.0").description("Gira App Java Backend").contact(new Contact("Gira App Java Backend", "https://canglv.dev/", "cang.levan87@gmail.com")).build());

    }

    private ApiKey getSecurityScheme() {
        return new ApiKey("JWT", "Authorization", "header");
    }


    private SecurityContext getSecurityContext() {
        return SecurityContext.builder()
                .securityReferences(List.of(getSecurityReference()))
                .build();
    }

    private SecurityReference getSecurityReference() {

        AuthorizationScope globalScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope Scopes[] = new AuthorizationScope[1];
        Scopes[0] = globalScope;

        return new SecurityReference("JWT", Scopes);
    }
}
