package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        CliApp cliApp = ctx.getBean("cliApp", CliApp.class);

        cliApp.start();
        ctx.close();
    }

}