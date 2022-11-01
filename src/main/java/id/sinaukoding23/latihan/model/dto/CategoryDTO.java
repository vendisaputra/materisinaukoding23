package id.sinaukoding23.latihan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDTO extends BaseDTO{
    private Integer categoryId;

    private String categoryName;
}
