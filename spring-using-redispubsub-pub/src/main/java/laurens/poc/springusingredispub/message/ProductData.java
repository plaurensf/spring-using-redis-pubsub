package laurens.poc.springusingredispub.message;


import laurens.poc.springusingredispub.entities.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ProductData {

    private Product product;
    private String message;

}
