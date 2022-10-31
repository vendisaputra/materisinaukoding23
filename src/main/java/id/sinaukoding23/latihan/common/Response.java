package id.sinaukoding23.latihan.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class Response {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer total;

    private HttpStatus status;

    public Response(Object data, String message, int total, HttpStatus status) {
        this.data = data;
        this.message = message;
        this.total = total;
        this.status = status;
    }

    public Response(Object data, String message, HttpStatus status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public Response(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
