package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    // ****************************************************************
    //  THYMELEAF-SPECIFIC ARTIFACTS
    //  TemplateResolver <- TemplateEngine <- ViewResolver
    // ****************************************************************
    // Thymeleaf view resolver
    @Bean
    SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();

     // templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        // Template cache is true by default. Set to false if you want
        // templates to be automatically updated when modified.
        templateResolver.setCacheable(true);
        return templateResolver;
    }

    @Bean
    SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setEnableSpringELCompiler(true);

        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    ThymeleafViewResolver thymeleafViewResolver() {
    	ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();

    	viewResolver.setContentType("text/html;encoding=utf-8");
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setViewNames(new String[] {"index","*th"});
        viewResolver.setOrder(Integer.valueOf(1)); //  Higher priority than JSP
        return viewResolver;
    }

    // ****************************************************************
    //  JSP-SPECIFIC ARTIFACTS
    // ****************************************************************
    // JSP view resolver
    @Bean
    InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/templates/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewNames(new String[] {"*jsp"});
        viewResolver.setOrder(Integer.valueOf(2));
        return viewResolver;
    }
}
