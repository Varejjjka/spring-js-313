package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

//21-05 open homepage
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        
        //21-05
        try {
            openHomePage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //21-05 open homepage
    private static void openHomePage() throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080/admin");
    }
}
