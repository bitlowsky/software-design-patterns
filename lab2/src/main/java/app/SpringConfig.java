package app;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import html.FileParser;
import html.ITagFactory;
import html.SimpleTagFactory;
import html.base.Html;

@Configuration
public class SpringConfig {

    @Bean
    public FileParser fileParserBean(@Qualifier("divTagFactoryBean") ITagFactory tagFactory) {
        return new FileParser(tagFactory);
    }

    @Bean
    public SimpleTagFactory divTagFactoryBean() {
        return new SimpleTagFactory("div");
    }

    @Bean
    public SimpleTagFactory pTagFactoryBean() {
        return new SimpleTagFactory("p");
    }

    @Bean
    public Html htmlBean(FileParser fp) {
        return fp.getHtml("html.txt");
    }

    @Bean(name = { "cliApp", "cliAppBean" })
    public CliApp cliAppBean(Html html) {
        return new CliApp(html);
    }

}