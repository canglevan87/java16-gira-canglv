package cybersoft.javabackend.java16giracanglv.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("cybersoft.javabackend.java16giracanglv")).build().apiInfo(new ApiInfoBuilder()
                        .title("Gira App Java Backend").version("1.0").description("Gira App Java Backend").contact(new Contact("Gira App Java Backend", "https://canglv.dev/", "cang.levan87@gmail.com")).build());

    }
}
