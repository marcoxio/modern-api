package com.packt.modern.api.service;

import com.packt.modern.api.entity.OrderEntity;
import com.packt.modern.api.model.NewOrder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot
 **/
public interface OrderService {

  public Mono<OrderEntity> addOrder(@Valid Mono<NewOrder> newOrder);
  Mono<OrderEntity> updateMapping(@Valid OrderEntity orderEntity);
  public Flux<OrderEntity> getOrdersByCustomerId(@NotNull @Valid String customerId);
  public Mono<OrderEntity> getByOrderId(String id);
}
