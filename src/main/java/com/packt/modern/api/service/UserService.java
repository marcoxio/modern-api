package com.packt.modern.api.service;

import com.packt.modern.api.entity.AddressEntity;
import com.packt.modern.api.entity.CardEntity;
import com.packt.modern.api.entity.UserEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot
 **/
public interface UserService {
  public Mono<Void> deleteCustomerById(String id);
  Mono<Void> deleteCustomerById(UUID id);
  public Flux<AddressEntity> getAddressesByCustomerId(String id);
  public Flux<UserEntity> getAllCustomers();
  public Mono<CardEntity> getCardByCustomerId(String id);
  public Mono<UserEntity> getCustomerById(String id);
}
