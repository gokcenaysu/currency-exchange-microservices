package com.example.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Account {

    @Id
    @SequenceGenerator(
            name="account_id_sequence",
            sequenceName = "account_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_id_sequence"
            )
    private Long id;
    private LocalDateTime date;
    private String accountType;
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "account")
    private List<Currency> currencies;

    @OneToMany(mappedBy = "account")
    private List<AccountActivity> accountActivities;
}
