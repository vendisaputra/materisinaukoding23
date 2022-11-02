package id.sinaukoding23.latihan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "staffs")
@Entity
@Getter
@Setter
public class Staff extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer staffId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Staff manager;

    @OneToMany(mappedBy = "manager")
    private List<Staff> staffList;


}
