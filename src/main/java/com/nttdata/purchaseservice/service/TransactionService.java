package com.nttdata.purchaseservice.service;

import com.nttdata.purchaseservice.entity.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {

    Flux<Transaction> findAll();

    Mono<Transaction> findById(String id);

    Mono<Transaction> save(Transaction transaction);

    Mono<Transaction> update(String id, Transaction transaction);

    Mono<Transaction> delete(String id);
}
