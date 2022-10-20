package com.wings.penjualan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/product/list");
        registry.addViewController("/product").setViewName("forward:/product/list");
    }

    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver session = new SessionLocaleResolver();
        Locale indonesia = new Locale("id","ID");

        session.setDefaultLocale(indonesia);

        return session;
    }
}
