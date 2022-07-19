package com.nttdata.purchase.service;

import com.nttdata.purchase.entity.Purchase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PurchaseService {

    Flux<Purchase> findAll();

    Mono<Purchase> findById(String id);

    Mono<Purchase> save(Purchase purchase);

    Mono<Purchase> update(Purchase purchase);

    Mono<Purchase> delete(String id);
}
