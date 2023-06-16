package com.packt.modern.api.service;

import com.packt.modern.api.entity.ShipmentEntity;
import reactor.core.publisher.Flux;

import javax.validation.constraints.Min;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot
 **/
public interface ShipmentService {
  public Flux<ShipmentEntity> getShipmentByOrderId(@Min(value = 1L, message = "Invalid product ID.")  String id);
}
