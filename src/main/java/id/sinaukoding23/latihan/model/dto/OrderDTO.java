package id.sinaukoding23.latihan.model.dto;

import id.sinaukoding23.latihan.model.enums.StatusOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderDTO extends BaseDTO{
    private Integer orderId;

    private StatusOrder statusOrder;

    private Date orderDate;

    private Date requiredDate;

    private Date shippedDate;

    private CustomerDTO customer;

    private StoreDTO store;

    private StaffDTO staff;
}
