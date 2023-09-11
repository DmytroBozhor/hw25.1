package com.example.hw25.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table("order")
public class Order {
    @Id
    private int id;
    private Timestamp date;
    private int cost;

//    @ManyToAny
//    private List<Product> products;
}
