package com.danvarga.msscbeerinventoryfailover.web;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.web.servlet.function.RouterFunction;
//
//import static org.springframework.web.servlet.function.RequestPredicates.GET;
//import static org.springframework.web.servlet.function.RequestPredicates.accept;
//import static org.springframework.web.servlet.function.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RouterConfig {

    // MVC impl - for local BOM
//    @Bean
//    public RouterFunction inventoryRoute(InventoryHandler inventoryHandler) {
//        return route(GET("/inventory-failover").and(accept(MediaType.APPLICATION_JSON)),
//                inventoryHandler);
//    }


    @Bean
    public RouterFunction inventoryRoute(InventoryHandler inventoryHandler) {
        return route(GET("/inventory-failover").and(accept(MediaType.APPLICATION_JSON)),
                inventoryHandler::listInventory);
    }
}
