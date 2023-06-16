package com.packt.modern.api.repository;

import com.packt.modern.api.entity.AuthorizationEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface AuthorizationRepository extends ReactiveCrudRepository<AuthorizationEntity, UUID> {
}
