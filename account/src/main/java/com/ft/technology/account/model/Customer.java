package com.ft.technology.account.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Customer {

    @Id
    @SequenceGenerator(
            name="customer_id_sequence",
            sequenceName="customer_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private Long id;
    private String email;
    private String password;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;
}
