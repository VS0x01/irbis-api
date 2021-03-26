package ua.edu.kneu.irbisapi.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ua.edu.kneu.irbisapi.interceptors.DBChooser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WebConfig implements WebMvcConfigurer {
    private final DBChooser dbChooser;
    private final List<String> patterns;

    public WebConfig(DBChooser dbChooser) {
        this.dbChooser = dbChooser;
        patterns = Arrays.stream(Databases.values())
                .map(v -> "/" + v.toString().toLowerCase() + "/**")
                .collect(Collectors.toList());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(dbChooser).addPathPatterns(patterns);
    }
}
