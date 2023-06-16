package com.packt.modern.api.service;

import com.packt.modern.api.entity.CartEntity;
import com.packt.modern.api.entity.ItemEntity;
import com.packt.modern.api.model.Item;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ItemService {
    Mono<ItemEntity> toEntity(Mono<Item> e);

    Mono<List<Item>> fluxTolList(Flux<ItemEntity> items);

    Flux<Item> toItemFlux(Mono<CartEntity> items);

    ItemEntity toEntity(Item m);

    List<ItemEntity> toEntityList(List<Item> items);

    Item toModel(ItemEntity e);

    List<Item> toModelList(List<ItemEntity> items);

    Flux<Item> toModelFlux(List<ItemEntity> items);
}
