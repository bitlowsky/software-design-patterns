package app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import html.FileParser;
import html.SimpleTagFactory;
import html.base.Html;

@Configuration
public class SpringConfig {

    @Bean
    public FileParser fileParser() {
        return new FileParser(simpleTagFactory());
    }

    @Bean
    public SimpleTagFactory simpleTagFactory() {
        return new SimpleTagFactory("div");
    }

    @Bean
    public Html html() {
        return fileParser().getHtml("html.txt");
    }

    @Bean
    public CliApp cliApp() {
        return new CliApp(html());
    }

}