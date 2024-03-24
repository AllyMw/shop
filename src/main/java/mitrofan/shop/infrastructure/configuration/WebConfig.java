package mitrofan.shop.infrastructure.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Разрешить CORS запросы к любым URL
                .allowedOrigins("http://localhost:3000") // URL вашего клиентского приложения
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Разрешенные методы
                .allowedHeaders("*") // Разрешить все заголовки
                .allowCredentials(true) // Разрешить отправку cookies
                .maxAge(3600); // Максимальное время, на которое результат предварительного запроса может быть кэширован
    }
}