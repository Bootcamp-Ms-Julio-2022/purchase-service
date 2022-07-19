package com.nttdata.purchase.service.impl;

import com.nttdata.purchase.entity.Purchase;
import com.nttdata.purchase.repository.PurchaseRepository;
import com.nttdata.purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public Flux<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    @Override
    public Mono<Purchase> findById(String id) {
        return purchaseRepository.findById(id);
    }

    @Override
    public Mono<Purchase> save(Purchase purchase) {
        purchase.setCreatedAt(new Date());
        purchase.setState("active");
        return purchaseRepository.save(purchase);
    }

    @Override
    public Mono<Purchase> update(Purchase purchase) {
        return purchaseRepository.findById(purchase.getId())
                .flatMap(p -> {
                    p.setCustomerId(purchase.getCustomerId());
//                    p.setCustomerType(purchase.getCustomerType());
//                    p.setCustomerName(purchase.getCustomerName());
                    p.setProductId(purchase.getProductId());
//                    p.setProductType(purchase.getProductType());
//                    p.setProductCategory(purchase.getProductCategory());
                    p.setState(purchase.getState());
                    p.setAccountNo(purchase.getAccountNo());
                    p.setBalance(purchase.getBalance());
                    p.setHasCommissionPerMaintenance(purchase.getHasCommissionPerMaintenance());
                    p.setCommissionPerMaintenancePercentage(purchase.getCommissionPerMaintenancePercentage());
                    p.setHasTransactionLimitPerMonth(purchase.getHasTransactionLimitPerMonth());
                    p.setTransactionLimitPerMonthNumber(purchase.getTransactionLimitPerMonthNumber());
                    p.setMaxQtyOfCreditsAllowed(purchase.getMaxQtyOfCreditsAllowed());
                    p.setCreditLimitAmount(purchase.getCreditLimitAmount());
//                    p.setHeadlines(purchase.getHeadlines());
//                    p.setAuthSigners(purchase.getAuthSigners());
                    p.setTransactionsMadeByCustomerInCurrentMonth(purchase.getTransactionsMadeByCustomerInCurrentMonth());
                    p.setPurchaseSource(purchase.getPurchaseSource());
//                    p.setTransactions(purchase.getTransactions());
                    return purchaseRepository.save(p);
                });
    }

    @Override
    public Mono<Purchase> delete(String id) {
        return purchaseRepository.findById(id)
                .flatMap(p -> purchaseRepository.delete(p)
                        .then(Mono.just(p)));
    }
}
