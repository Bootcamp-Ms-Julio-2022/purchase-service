package com.nttdata.purchaseservice.service;

import com.nttdata.purchaseservice.entity.Purchase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PurchaseService {

    Flux<Purchase> findAll();

    Mono<Purchase> findById(String id);

    Mono<Purchase> save(Purchase purchase);

    Mono<Purchase> update(String id, Purchase purchase);

    Mono<Purchase> delete(String id);
}
