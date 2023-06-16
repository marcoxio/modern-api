package com.packt.modern.api.service;

import com.packt.modern.api.entity.AddressEntity;
import com.packt.modern.api.model.AddAddressReq;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

public interface AddressService {
    public Mono<AddressEntity> createAddress(Mono<AddAddressReq> addAddressReq);
    public Mono<Void> deleteAddressesById(String id);
    Mono<Void> deleteAddressesById(UUID id);
    public Mono<AddressEntity> getAddressesById(String id);
    public Flux<AddressEntity> getAllAddresses();
}
