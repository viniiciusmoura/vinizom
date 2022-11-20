package br.com.ecommercepalmas;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SettingsSpringMVC implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "produtos/list");
        registry.addRedirectViewController("/home", "produtos/list");
        //registry.addViewController("/").setViewName("vendas/list");
    }
}
