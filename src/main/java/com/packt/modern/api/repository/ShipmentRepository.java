package com.packt.modern.api.repository;

import com.packt.modern.api.entity.ShipmentEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface ShipmentRepository extends ReactiveCrudRepository<ShipmentEntity, UUID> {
    @Query("SELECT s.* FROM ecomm.order o, ecomm.shipment s where o.shipment_id=s.id and o.id = :id")
    Flux<ShipmentEntity> getShipmentByOrderId(String id);
}
