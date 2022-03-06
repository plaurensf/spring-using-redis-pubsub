package laurens.poc.springusingredispub.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<?> exceptionProduct(ProductException e){
        return new ResponseEntity<>(e.getType().getMessage(), e.getType().getStatus());
    }


}
