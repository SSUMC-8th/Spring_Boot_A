package umc.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.spring.service.MarketQueryService;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext context) {
//		return args -> {
//			MarketQueryService marketService = context.getBean(MarketQueryService.class);
//
//			String name ="요아정";
//			Float score = 4.0f;
//
//			System.out.println("Executing findMarketsByNameAndScore with parameters:");
//			System.out.println("Name: " + name);
//			System.out.println("Score: " + score);
//
//			marketService.findMarketByNameAndScore(name, score)
//					.forEach(System.out::println);
//		};
//	}

}
