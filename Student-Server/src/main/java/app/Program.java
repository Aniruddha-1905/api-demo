package app;

import java.net.URI;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.simple.SimpleContainerFactory;

/**
 * Application entry point
 */
public class Program {

    public static void main(String[] args) {

        ResourceConfig config = new ResourceConfig()
                .packages("app.resource"); // scans StudentManagerApi

        URI baseUri = URI.create("http://localhost:5000/");

        SimpleContainerFactory.create(baseUri, config);

        System.out.println("Server started at " + baseUri);
        System.out.println("API: " + baseUri + "api/students/all");
    }
}
