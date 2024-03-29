package ua.edu.kneu.irbisapi.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ua.edu.kneu.irbisapi.interceptor.DBChooser;
import ua.edu.kneu.irbisapi.interceptor.FormatChooser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MvcConfig implements WebMvcConfigurer {
    private final DBChooser dbChooser;
    private final FormatChooser formatChooser;
    private final List<String> patterns;

    public MvcConfig(DBChooser dbChooser, FormatChooser formatChooser) {
        this.dbChooser = dbChooser;
        this.formatChooser = formatChooser;
        patterns = Arrays.stream(Databases.values())
                .map(v -> "/" + v.toString().toLowerCase() + "/**")
                .collect(Collectors.toList());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://10.1.1.123", "http://localhost:8080", "https://vs0x01.github.io");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(dbChooser).addPathPatterns(patterns);
        registry.addInterceptor(formatChooser).addPathPatterns(patterns);
    }
}
