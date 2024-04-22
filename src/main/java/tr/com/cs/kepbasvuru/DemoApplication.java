package tr.com.cs.kepbasvuru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		System.setProperty("jdk.httpclient.HttpClient.log","all");
		SpringApplication.run(DemoApplication.class, args);
	}

}
