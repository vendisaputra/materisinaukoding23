package id.sinaukoding23.latihan.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderItemDTO extends BaseDTO{
    private Integer orderItemId;

    private Integer quantity;

    private BigDecimal listPrice;

    private BigDecimal discount;

    private OrderDTO order;

    private ProductDTO product;
}
