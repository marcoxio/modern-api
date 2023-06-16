package com.packt.modern.api.service;

import com.packt.modern.api.entity.CardEntity;
import com.packt.modern.api.model.AddCardReq;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

public interface CardService {
    public Mono<Void> deleteCardById(String id);
    public Mono<Void> deleteCardById(UUID id);
    public Flux<CardEntity> getAllCards();

    public Mono<CardEntity> getCardById(String id);

    public Mono<CardEntity> registerCard(@Valid Mono<AddCardReq> addCardReq);
    CardEntity toEntity(AddCardReq model);
}
