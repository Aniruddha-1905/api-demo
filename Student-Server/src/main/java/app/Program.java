package app;

import java.net.URI;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.simple.SimpleContainerFactory;


public class Program {

    public static void main(String[] args) {

        // Render / Cloud compatible port handling
        int port = Integer.parseInt(
                System.getenv().getOrDefault("PORT", "5000")
        );

        // Bind to all interfaces (REQUIRED for cloud)
        URI baseUri = URI.create("http://0.0.0.0:" + port + "/");

        ResourceConfig config = new ResourceConfig()
                .packages("app.resource");

        SimpleContainerFactory.create(baseUri, config);

        System.out.println("Server started at " + baseUri);
    }
}
