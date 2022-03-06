package laurens.poc.springusingredispub.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ProductException extends RuntimeException {

    private final Type type;

    public ProductException(Type type){
        super(type.getMessage());
        this.type = type;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Type {
        PRODUCT_NOTFOUND("ID product not found in DB", HttpStatus.NOT_FOUND);

        private final String message;
        private final HttpStatus status;
    }
}
