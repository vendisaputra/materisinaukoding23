package id.sinaukoding23.latihan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private Integer customerId;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private String street;

    private String city;

    private String state;

    private String zipCode;
}
