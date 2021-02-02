package com.danvarga.msscbeerinventoryfailover.web;

// MVC impl - for using local BOM

//import com.danvarga.brewery.model.BeerInventoryDto;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.function.HandlerFunction;
//import org.springframework.web.servlet.function.ServerRequest;
//import org.springframework.web.servlet.function.ServerResponse;
//
//import java.time.OffsetDateTime;
//import java.util.Collections;
//import java.util.UUID;
//
//@Component
//public class InventoryHandler implements HandlerFunction {
//
//    @Override
//    public ServerResponse handle(ServerRequest request) throws Exception {
//        return ServerResponse.ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(Collections.singletonList(BeerInventoryDto.builder()
//                        .id(UUID.randomUUID())
//                        .beerId(new UUID(0, 0))
//                        .quantityOnHand(999)
//                        .createdDate(OffsetDateTime.now())
//                        .lastModifiedDate(OffsetDateTime.now())
//                        .build()));
//    }
//}

import com.danvarga.brewery.model.BeerInventoryDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class InventoryHandler {
    public Mono<ServerResponse> listInventory(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(Mono.just(Arrays.asList(
                        BeerInventoryDto.builder()
                                .id(UUID.randomUUID())
                                .beerId(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                                .quantityOnHand(999)
                                .createdDate(OffsetDateTime.now())
                                .lastModifiedDate(OffsetDateTime.now())
                                .build())), List.class);
    }
}
