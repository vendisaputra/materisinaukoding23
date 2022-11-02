package id.sinaukoding23.latihan.model.dto;

import id.sinaukoding23.latihan.model.Store;
import id.sinaukoding23.latihan.model.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StoreDTO extends BaseDTO {
    private Integer storeId;

    private String storeName;

    private String phone;

    private String email;

    private String street;

    private String city;

    private String state;

    private String zipCode;

}
