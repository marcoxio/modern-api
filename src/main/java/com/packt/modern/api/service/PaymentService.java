package com.packt.modern.api.service;

import com.packt.modern.api.entity.AuthorizationEntity;
import com.packt.modern.api.model.PaymentReq;
import reactor.core.publisher.Mono;

import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot
 **/
public interface PaymentService {

  public Mono<AuthorizationEntity> authorize(@Valid Mono<PaymentReq> paymentReq);
  public Mono<AuthorizationEntity> getOrdersPaymentAuthorization(@NotNull String orderId);
}
