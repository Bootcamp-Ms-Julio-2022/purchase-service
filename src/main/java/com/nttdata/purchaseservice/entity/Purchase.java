package com.nttdata.purchaseservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "purchase")
public class Purchase {

    @Id
    private String id;

    private String customerId;

    private String customerType;

    private String customerName;

    private String productId;

    private String productType;

    private String productCategory;

    private Date createdAt;

    private String state;

    private String accountNo;

    private Double balance;

    private Boolean HasCommissionPerMaintenance;

    private Double commissionPerMaintenancePercentage;

    private Boolean HasTransactionLimitPerMonth;

    private Integer transactionLimitPerMonthNumber;

    private Integer maxQtyOfCreditsAllowed;

    private Double creditLimitAmount;

    private String[] headlines;

    private String[] authSigners;

    private Integer transactionsMadeByCustomerInCurrentMonth;

    private String purchaseSource;

    private List<Transaction> transactions;

    public Purchase() {
        this.transactions = new ArrayList<>();
    }
}
