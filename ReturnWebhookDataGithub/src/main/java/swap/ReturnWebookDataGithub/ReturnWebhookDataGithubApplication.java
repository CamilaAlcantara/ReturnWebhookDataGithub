package swap.ReturnWebookDataGithub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ReturnWebhookDataGithubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReturnWebhookDataGithubApplication.class, args);
	}

}
