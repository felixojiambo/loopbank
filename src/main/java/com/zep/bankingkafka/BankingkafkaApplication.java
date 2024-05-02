package com.zep.bankingkafka;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//using Springdoc OpenAPI, removing the @EnableSwagger2 annotation
// and ensuring that all Swagger/OpenAPI annotations are from the Springdoc package.
//@EnableSwagger2
@OpenAPIDefinition(
		info = @Info(
				title = "loopbanking",
				description = "Backend APIs for Loop Bank",
				version = "v1.0",
				contact = @Contact(
						name = "Ojiambo Felix",
						email = "ojiamboloc@gmail.com",
						url = "https://github.com/felixojiambo/loopbank.git"
				),
				license = @License(
						name = "Ojiambo Felix",
						url = "https://github.com/felixojiambo/loopbank.git"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Felix Docs",
				url = "https://github.com/felixojiambo/loopbank.git"
		)
)
public class BankingkafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingkafkaApplication.class, args);
		System.out.println("Zep Loop");
	}

}
