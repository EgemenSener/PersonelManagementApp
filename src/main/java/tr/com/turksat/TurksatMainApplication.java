package tr.com.turksat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TurksatMainApplication {
	public static void main(String[] args) {
		System.setProperty("jdk.httpclient.HttpClient.log","all");
		SpringApplication.run(TurksatMainApplication.class, args);
	}

}
