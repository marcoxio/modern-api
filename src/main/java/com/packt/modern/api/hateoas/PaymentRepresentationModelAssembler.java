package com.packt.modern.api.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.packt.modern.api.controller.PaymentController;
import com.packt.modern.api.entity.PaymentEntity;
import com.packt.modern.api.model.Payment;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.reactive.ReactiveRepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PaymentRepresentationModelAssembler implements ReactiveRepresentationModelAssembler<PaymentEntity, Payment>, HateoasSupport {


    /**
     * Coverts the Payment entity to resource
     * @param entity
     * @return
     */
    @Override
    public Mono<Payment> toModel(PaymentEntity entity, ServerWebExchange exchange) {
        return Mono.just(entityToModel(entity));
    }

    public Payment entityToModel(PaymentEntity entity) {
        Payment resource = new Payment();
        if(Objects.isNull(entity)) {
            return resource;
        }
        BeanUtils.copyProperties(entity, resource);
        resource.add(Link.of("/api/v1/Payments").withRel("Payments"));
        resource.add(Link.of(String.format("/api/v1/Payments/%s", entity.getId())).withRel("self"));
        return resource;
    }

    public Payment getModel(Mono<Payment> m) {
        AtomicReference<Payment> model = new AtomicReference<>();
        m.cache().subscribe(i -> model.set(i));
        return model.get();
    }

    /**
     * Coverts the collection of Product entities to list of resources.
     *
     * @param entities
     */
    public Flux<Payment> toListModel(Flux<PaymentEntity> entities) {
        if (Objects.isNull(entities)) {
            return Flux.empty();
        }
        return Flux.from(entities.map(e -> entityToModel(e)));
    }
}
