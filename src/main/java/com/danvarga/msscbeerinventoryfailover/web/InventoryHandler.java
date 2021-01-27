package com.danvarga.msscbeerinventoryfailover.web;

import com.danvarga.brewery.model.BeerInventoryDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.HandlerFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.UUID;

@Component
public class InventoryHandler implements HandlerFunction {

    @Override
    public ServerResponse handle(ServerRequest request) throws Exception {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Collections.singletonList(BeerInventoryDto.builder()
                        .id(UUID.randomUUID())
                        .beerId(new UUID(0, 0))
                        .quantityOnHand(999)
                        .createdDate(OffsetDateTime.now())
                        .lastModifiedDate(OffsetDateTime.now())
                        .build()));
    }
}
