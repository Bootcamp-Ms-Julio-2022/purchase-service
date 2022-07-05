package com.nttdata.purchaseservice.repository;

import com.nttdata.purchaseservice.entity.Purchase;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PurchaseRepository extends ReactiveMongoRepository<Purchase, String> {

    Flux<Purchase> findAllByCustomerId(String customerId);
}
