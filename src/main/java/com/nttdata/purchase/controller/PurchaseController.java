package com.nttdata.purchase.controller;

import com.nttdata.purchase.entity.Purchase;
import com.nttdata.purchase.service.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    // -------------------Retrieve all purchases

    @GetMapping
    public Flux<Purchase> retrieveAll() {
        log.info("Retrieving all purchases");
        return purchaseService.findAll();
    }

    // -------------------Retrieve single purchase by id

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Purchase>> retrieveById(@PathVariable("id") String id) {
        log.info("Retrieving purchase with id: " + id);
        Mono<Purchase> purchase = purchaseService.findById(id);
        return purchase.map(p -> ResponseEntity.ok(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // -------------------Create a purchase

    @PostMapping
    public Mono<Purchase> save(@RequestBody Purchase purchase) {
        log.info("Registering new purchase - customer: " + purchase.getCustomerId() + ", product: " + purchase.getProductId());
        return purchaseService.save(purchase);
    }

    // -------------------Update a purchase

    @PutMapping
    public Mono<ResponseEntity<Purchase>> update(@RequestBody Purchase purchase) {
        log.info("Updating purchase with id: " + purchase.getId());
        return purchaseService.update(purchase)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    // -------------------Delete a purchase

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable("id") String id) {
        log.info("Deleting purchase with id: " + id);
        return purchaseService.delete(id)
                .map(p -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
