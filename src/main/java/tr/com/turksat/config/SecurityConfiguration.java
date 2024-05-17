package tr.com.turksat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    private final PropertiesConfiguration propertiesConfiguration;

    @Autowired
    public SecurityConfiguration(PropertiesConfiguration thePropertiesConfiguration) {
        propertiesConfiguration = thePropertiesConfiguration;
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails application = User.builder().username(propertiesConfiguration.getSpringUsername()).password("{noop}" + propertiesConfiguration.getSpringPassword()).roles("APPLICATION").build();

        return new InMemoryUserDetailsManager(application);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().authenticated()
                );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}