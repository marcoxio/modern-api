package com.packt.modern.api.service;

import com.packt.modern.api.entity.CartEntity;
import com.packt.modern.api.entity.ItemEntity;
import com.packt.modern.api.entity.ProductEntity;
import com.packt.modern.api.model.Item;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    @Override
    public Mono<ItemEntity> toEntity(Mono<Item> model) {
       return model.map(m ->
           new ItemEntity()//.setProduct(new ProductEntity().setId(UUID.fromString(m.getId())))
                   .setPrice(m.getUnitPrice())
                   .setQuantity(m.getQuantity())
       );
    }

    @Override
    public List<ItemEntity> toEntityList(List<Item> items) {
        if (Objects.isNull(items)) {
            return Collections.emptyList();
        }
        return items.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public Mono<List<Item>> fluxTolList(Flux<ItemEntity> items) {
        if (Objects.isNull(items)) {
            return Mono.just(Collections.emptyList());
        }
        return items.map(this::toModel).collectList();
    }

    @Override
    public Flux<Item> toItemFlux(Mono<CartEntity> cart) {
        if (Objects.isNull(cart)) {
            return Flux.empty();
        }
        return cart.flatMapMany(c -> toModelFlux(c.getItems()));
    }

    @Override
    public ItemEntity toEntity(Item m) {
        ItemEntity e = new ItemEntity();
        e.setProductId(UUID.fromString(m.getId()))
                .setPrice(m.getUnitPrice())
                .setQuantity(m.getQuantity());
        return e;
    }


    @Override
    public Item toModel(ItemEntity e) {
        Item m = new Item();
        m.id(e.getProductId().toString())
                .unitPrice(e.getPrice()).quantity(e.getQuantity());
        return m;
    }

    @Override
    public List<Item> toModelList(List<ItemEntity> items) {
        if (Objects.isNull(items)) {
            return Collections.emptyList();
        }
        return items.stream().map(e -> toModel(e)).collect(Collectors.toList());
    }

    @Override
    public Flux<Item> toModelFlux(List<ItemEntity> items) {
        if (Objects.isNull(items)) {
            return Flux.empty();
        }
        return Flux.fromIterable(items.stream().map(this::toModel).collect(Collectors.toList()));
    }
}
