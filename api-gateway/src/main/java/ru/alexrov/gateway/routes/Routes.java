package ru.alexrov.gateway.routes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.setPath;

@Configuration
public class Routes {

    @Value("${service.products_url}")
    private String products_url;
    @Value("${service.products_host}")
    private String products_host;

    @Value("${service.orders_url}")
    private String orders_url;
    @Value("${service.orders_host}")
    private String orders_host;

    @Value("${service.inventory_url}")
    private String inventory_url;
    @Value("${service.inventory_host}")
    private String inventory_host;

    @Bean
    public RouterFunction<ServerResponse> productServiceRoute(){
        return GatewayRouterFunctions.route("product_service")
                .route(RequestPredicates.path(products_url), HandlerFunctions.http(products_host))
                .route(RequestPredicates.path(products_url + "/*"), HandlerFunctions.http(products_host))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> productServiceSwaggerRoute(){
        return GatewayRouterFunctions.route("product_service_swagger")
                .route(RequestPredicates.path("/aggregate/products-service/v3/api-docs"), HandlerFunctions.http(products_host))
                .filter(setPath("/api-docs"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> orderServiceRoute(){
        return GatewayRouterFunctions.route("order_service")
                .route(RequestPredicates.path(orders_url), HandlerFunctions.http(orders_host))
                .route(RequestPredicates.path(orders_url + "/*"), HandlerFunctions.http(orders_host))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> orderServiceSwaggerRoute(){
        return GatewayRouterFunctions.route("order_service_swagger")
                .route(RequestPredicates.path("/aggregate/orders-service/v3/api-docs"), HandlerFunctions.http(orders_host))
                .filter(setPath("/api-docs"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> inventoryServiceRoute(){
        return GatewayRouterFunctions.route("inventory_service")
                .route(RequestPredicates.path(inventory_url), HandlerFunctions.http(inventory_host))
                .route(RequestPredicates.path(inventory_url + "/*"), HandlerFunctions.http(inventory_host))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> inventoryServiceSwaggerRoute(){
        return GatewayRouterFunctions.route("inventory_service_swagger")
                .route(RequestPredicates.path("/aggregate/inventory-service/v3/api-docs"), HandlerFunctions.http(inventory_host))
                .filter(setPath("/api-docs"))
                .build();
    }
}
