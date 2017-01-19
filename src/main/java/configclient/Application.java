package configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class Application {
	
	
	@Value("${redis.name}")
	public String Name = "default Name";
	@Value("${redis.passwd}")
	public String passwd = "Default Passwd";
	
	
	@Autowired
    public Environment environment;

	
	@RequestMapping("/e")
	public String showDataUsingEnv() {
		return environment.getProperty("redis.name") + "\n" + environment.getProperty("redis.passwd");
	}
	
	@RequestMapping("/r")
	public String showDataUsingvalue() {
		return Name + "\n" + passwd;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
