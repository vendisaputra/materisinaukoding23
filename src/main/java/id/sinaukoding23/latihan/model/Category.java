package id.sinaukoding23.latihan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "categories")
@Entity
@Setter
@Getter
public class Category extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;
}
