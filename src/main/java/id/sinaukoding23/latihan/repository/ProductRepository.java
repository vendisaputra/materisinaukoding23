package id.sinaukoding23.latihan.repository;

import id.sinaukoding23.latihan.model.Customer;
import id.sinaukoding23.latihan.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Customer> findAllByIsDeleted(boolean isDelete);

    @Query(value = "Select *from customer where is_delete = ?1 and customer_id = ?2", nativeQuery = true)
    List<Customer> findByIsDelete(boolean isDelete, int id);

    @Query(value = "Select *from customer where is_delete = :delete AND customer_id = :id", nativeQuery = true)
    List<Customer> findByIsDelete2(@Param("delete") boolean isDelete, @Param("id") int id);

    List<Customer> findAllByProductId(int id);

    Customer findByProductId(int id);
}
