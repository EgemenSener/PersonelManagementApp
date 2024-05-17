package tr.com.turksat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfiguration {
    @Value("${app.springUsername}")
    private String springUsername;

    @Value("${app.springPassword}")
    private String springPassword;

    public String getSpringUsername() {
        return springUsername;
    }

    public String getSpringPassword() {
        return springPassword;
    }
}
