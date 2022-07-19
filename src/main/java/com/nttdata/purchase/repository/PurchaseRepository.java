package com.nttdata.purchase.repository;

import com.nttdata.purchase.entity.Purchase;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PurchaseRepository extends ReactiveMongoRepository<Purchase, String> {

//    Flux<Purchase> findAllByCustomerId(String customerId);
}
