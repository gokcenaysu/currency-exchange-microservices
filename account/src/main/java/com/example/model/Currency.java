package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Currency {

    @Id
    @SequenceGenerator(
            name="currency_id_sequence",
            sequenceName = "currency_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "currency_id_sequence"
    )
    private Long id;
    private String type;
    private Integer count;
    private BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;
}
