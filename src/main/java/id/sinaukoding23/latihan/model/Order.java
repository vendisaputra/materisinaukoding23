package id.sinaukoding23.latihan.model;

import id.sinaukoding23.latihan.model.enums.StatusOrder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "orders")
@Entity
@Setter
@Getter
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column
    private StatusOrder statusOrder;

    @Column
    private Date orderDate;

    @Column
    private Date requiredDate;

    @Column
    private Date shippedDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
}
