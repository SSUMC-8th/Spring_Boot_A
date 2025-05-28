package umc.spring.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import umc.spring.validation.resolver.ValidPageResolver;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public WebConfig(ValidPageResolver validPageResolver) {
        System.out.println("✅ WebConfig 생성됨");
        this.validPageResolver = validPageResolver;
    }

    private final ValidPageResolver validPageResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        System.out.println("Resolver 추가됨");
        resolvers.add(validPageResolver);
    }
}