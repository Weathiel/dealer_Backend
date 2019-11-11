package eu.rogowski.dealer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DealerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DealerApplication.class, args);
	}

}
