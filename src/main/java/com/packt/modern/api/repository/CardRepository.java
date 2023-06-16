package com.packt.modern.api.repository;

import com.packt.modern.api.entity.CardEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface CardRepository extends ReactiveCrudRepository<CardEntity, UUID> {
}
