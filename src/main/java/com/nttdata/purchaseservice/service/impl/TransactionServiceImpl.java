package com.nttdata.purchaseservice.service.impl;

import com.nttdata.purchaseservice.entity.Transaction;
import com.nttdata.purchaseservice.repository.TransactionRepository;
import com.nttdata.purchaseservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Flux<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Mono<Transaction> findById(String id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Mono<Transaction> save(Transaction transaction) {
        transaction.setEmittedAt(new Date());
        return transactionRepository.save(transaction);
    }

    @Override
    public Mono<Transaction> update(String id, Transaction transaction) {
        return transactionRepository.findById(id)
                .flatMap(t -> {
                    t.setType(transaction.getType());
                    t.setAmount(transaction.getAmount());
                    t.setState(transaction.getState());
                    t.setSource(transaction.getSource());
                    return transactionRepository.save(t);
                });
    }

    @Override
    public Mono<Transaction> delete(String id) {
        return transactionRepository.findById(id)
                .flatMap(t -> transactionRepository.delete(t)
                        .then(Mono.just(t)));
    }
}
