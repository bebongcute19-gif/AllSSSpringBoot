package re.ss12.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean // modelmapper
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}