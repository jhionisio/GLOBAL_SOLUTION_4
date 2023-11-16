package life.assisten.forall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class DocumentationConfig {

        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI()
                                .info(new Info()
                                                .title("ForAll API")
                                                .description("Uma API")
                                                .summary("Essa api")
                                                .version("V1")
                                                .contact(new Contact()
                                                                .name("João Marcelo")
                                                                .email("mr.joaomarcelo@gmail.com")))
                                .components(new Components()
                                                .addSecuritySchemes("jwt-key",
                                                                new SecurityScheme()
                                                                                .type(SecurityScheme.Type.APIKEY)
                                                                                .in(SecurityScheme.In.HEADER)
                                                                                .name("Authorization")));
        }
}
