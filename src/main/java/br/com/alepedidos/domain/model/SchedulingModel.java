package br.com.alepedidos.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_scheduling")
@Data
public class SchedulingModel extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "delivery_date")
    private Date deliveryDate;
    @Column(name = "code")
    private Long code;
    @Column(name = "qrcode")
    private String qrcode;
    @Column(name = "discount")
    private double discount;
    @Column(name = "price_total")
    private BigDecimal priceTotal;
    @Column(name = "price_total_discount")
    private BigDecimal priceTotalDiscount;
    @Column(name = "payment_made")
    private boolean paymentMade;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "fk_scheduling_user", foreignKeyDefinition = "FOREIGN KEY (id_user) REFERENCES tb_user(id)"))
    private UserModel user;
    @OneToMany(mappedBy = "scheduling", fetch = FetchType.LAZY)
    private List<SchedulingProductModel> schedulingProducts;
    @ManyToOne
    @JoinColumn(name = "id_customer", foreignKey = @ForeignKey(name = "fk_scheduling_customer", foreignKeyDefinition = "FOREIGN KEY (id_customer) REFERENCES tb_customer(id)"))
    private CustomerModel customer;
}
