package senior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan("senior.*")
@Import(ConfigurationRepository.class)
@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class WebApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}