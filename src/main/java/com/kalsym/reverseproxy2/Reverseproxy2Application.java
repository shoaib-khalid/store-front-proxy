package com.kalsym.reverseproxy2;

import java.net.URI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Reverseproxy2Application {

    final Logger logger = LoggerFactory.getLogger(Reverseproxy2Application.class);
    public static HashMap<String, String> localDomains;

    public static void main(String[] args) {
        SpringApplication.run(Reverseproxy2Application.class, args);
        localDomains = new HashMap<>();
        localDomains.put("ideal-foods", "http://organic.storefront.com");
        localDomains.put("mcd", "http://fuse.storefront.com");
        localDomains.put("awan-tech", "http://old.storefront.com");
    }

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(
//                        // Set apache or nginx server to reverse proxy 
//                        // *.symplified.test requests to this application
//                        "r1", r -> r.host("*.symplified.test")
//                                // Forwards to respective URI and ignores the given uri at the bottom
//                                .filters(f -> f.changeRequestUri(e -> {
//                            // Match subdomain to one of reverse proxied Angular apps hosted by Apache or Nginx
//                            String domain = e.getRequest().getURI().toString();
//                            String subdomain = domain.split("\\.")[0].replaceFirst("^https?:\\/\\/", "");
//                            logger.info("Respective domain for " + subdomain + ": " + localDomains.get(subdomain));
//                            URI redirectURI = URI.create(localDomains.get(subdomain));
//                            logger.info("Forwarding request to: " + redirectURI.toString());
//                            return Optional.of(redirectURI);
//                        }))
//                                // Is required to build project
//                                // Does not forward to this URI if the above .filters method is used
//                                .uri("http://google.com")
//                ).build();
//    }
}
