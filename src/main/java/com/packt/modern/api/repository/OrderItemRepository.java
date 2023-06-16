package com.packt.modern.api.repository;

import com.packt.modern.api.entity.OrderItemEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface OrderItemRepository extends ReactiveCrudRepository<OrderItemEntity, UUID> {
}
