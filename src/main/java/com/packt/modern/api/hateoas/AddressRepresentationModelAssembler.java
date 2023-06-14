package com.packt.modern.api.hateoas;

import com.packt.modern.api.controller.AddressController;
import com.packt.modern.api.entity.AddressEntity;
import com.packt.modern.api.model.Address;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AddressRepresentationModelAssembler extends RepresentationModelAssemblerSupport<AddressEntity, Address> {

    /**
     * Creates a new {@link RepresentationModelAssemblerSupport} using the given controller class and
     * resource type.
     */
    public AddressRepresentationModelAssembler() {
        super(AddressController.class, Address.class);
    }

    /**
     * Coverts the Address entity to resource
     *
     * @param entity
     */
    @Override
    public Address toModel(AddressEntity entity) {
        Address resource = createModelWithId(entity.getId(), entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setId(entity.getId().toString());
        resource.add(
                WebMvcLinkBuilder.linkTo(methodOn(AddressController.class).getAddressesById(entity.getId().toString()))
                        .withSelfRel());
        return resource;
    }

    /**
     * Coverts the collection of Product entities to list of resources.
     *
     * @param entities
     */
    public List<Address> toListModel(Iterable<AddressEntity> entities) {
        if (Objects.isNull(entities)) {
            return Collections.emptyList();
        }

        return StreamSupport.stream(entities.spliterator(), false).map(this::toModel)
                .collect(Collectors.toList());
    }
}
