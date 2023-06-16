package com.packt.modern.api.service;

import com.packt.modern.api.entity.CardEntity;
import com.packt.modern.api.entity.UserEntity;
import com.packt.modern.api.model.AddCardReq;
import com.packt.modern.api.repository.CardRepository;
import com.packt.modern.api.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository repository;
    private final UserRepository userRepo;

    public CardServiceImpl(CardRepository repository, UserRepository userRepo) {
        this.repository = repository;
        this.userRepo = userRepo;
    }


    @Override
    public Mono<Void> deleteCardById(String id) {
        return repository.deleteById(UUID.fromString(id));

    }

    @Override
    public Mono<Void> deleteCardById(UUID id) {
        return repository.deleteById(id);
    }

    @Override
    public Flux<CardEntity> getAllCards() {
        return repository.findAll();
    }

    @Override
    public Mono<CardEntity> getCardById(String id) {
        return repository.findById(UUID.fromString(id));
    }

    @Override
    public Mono<CardEntity> registerCard(@Valid Mono<AddCardReq> addCardReq) {
        return addCardReq.map(this::toEntity).flatMap(repository::save);
    }


    @Override
    public  CardEntity toEntity(AddCardReq model) {
        CardEntity e = new CardEntity();
        BeanUtils.copyProperties(model, e);
        e.setNumber(model.getCardNumber());
        return e;
    }
}
