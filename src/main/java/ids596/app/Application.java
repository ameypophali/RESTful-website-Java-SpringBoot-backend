package ids596.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ids596.*")
public class Application {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = SpringApplication.run(Application.class, args);
	}
}
