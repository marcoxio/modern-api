package com.packt.modern.api.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.packt.modern.api.controller.PaymentController;
import com.packt.modern.api.entity.PaymentEntity;
import com.packt.modern.api.model.Payment;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class PaymentRepresentationModelAssembler extends RepresentationModelAssemblerSupport<PaymentEntity, Payment> {


    /**
     * Creates a new {@link RepresentationModelAssemblerSupport} using the given controller class and
     * resource type.
     */
    public PaymentRepresentationModelAssembler() {
        super(PaymentController.class, Payment.class);
    }

    /**
     * Coverts the Payment entity to resource
     *
     * @param entity
     */
    @Override
    public Payment toModel(PaymentEntity entity) {
        Payment resource = createModelWithId(entity.getId(), entity);
        BeanUtils.copyProperties(entity, resource);
        resource.setId(entity.getId().toString());
        // Self link generated by createModelWithId has missing api path. Therefore generating additionally.
        // can be removed once fixed.
        resource.add(linkTo(
                methodOn(PaymentController.class).getOrdersPaymentAuthorization(entity.getId().toString()))
                .withSelfRel());
        return resource;
    }

    /**
     * Coverts the collection of Product entities to list of resources.
     *
     * @param entities
     */
    public List<Payment> toListModel(Iterable<PaymentEntity> entities) {
        if (Objects.isNull(entities)) {
            return Collections.emptyList();
        }
        return StreamSupport.stream(entities.spliterator(), false).map(e -> toModel(e))
                .collect(Collectors.toList());
    }
}
