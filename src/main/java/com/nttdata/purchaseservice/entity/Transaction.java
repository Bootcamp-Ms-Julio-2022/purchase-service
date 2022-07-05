package com.nttdata.purchaseservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "transaction")
public class Transaction {

    @Id
    private String id;

    private String type;

    private Date emittedAt;

    private Double amount;

    private String state;

    private String source;
}
