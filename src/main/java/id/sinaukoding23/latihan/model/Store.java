package id.sinaukoding23.latihan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "stores")
@Entity
@Getter
@Setter
public class Store extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer storeId;

    @Column
    private String storeName;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String zipCode;

    @OneToMany(mappedBy = "store")
    private List<Stocks> stockList;

    @OneToMany(mappedBy = "store")
    private List<Staff> staffList;

    @OneToMany(mappedBy = "store")
    private List<Order> orderList;
}
