package com.packt.modern.api.service;

import com.packt.modern.api.entity.AddressEntity;
import com.packt.modern.api.model.AddAddressReq;

import java.util.Optional;

public interface AddressService {
    public Optional<AddressEntity> createAddress(AddAddressReq addAddressReq);
    public void deleteAddressesById(String id);
    public Optional<AddressEntity> getAddressesById(String id);
    public Iterable<AddressEntity> getAllAddresses();
}
