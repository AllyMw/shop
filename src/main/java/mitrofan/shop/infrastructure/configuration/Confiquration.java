package mitrofan.shop.infrastructure.configuration;

import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class Confiquration {

    @Value("${spring.datasource.url}")
    private String dbUrl;
    @PostConstruct
    public void init() {
        System.out.println(dbUrl);
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}