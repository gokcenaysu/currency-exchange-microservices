package com.example.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class AccountActivity {

    @Id
    @SequenceGenerator(
            name="account_id_sequence",
            sequenceName = "account_activity_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_activity_id_sequence"
    )
    private Long id;
    private String exchangeType;
    private LocalDateTime time;
    private Long count;
    private BigDecimal unitPrice;

    @Transient
    private BigDecimal amount;
    private String description;
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AccountActivity that = (AccountActivity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


    public BigDecimal getAmount() {
        return unitPrice.multiply(BigDecimal.valueOf(count));
    }

}
