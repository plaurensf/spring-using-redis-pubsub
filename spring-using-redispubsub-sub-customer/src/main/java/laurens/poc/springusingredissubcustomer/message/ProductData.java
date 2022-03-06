package laurens.poc.springusingredissubcustomer.message;

import laurens.poc.springusingredissubcustomer.entities.Product;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductData {

    private Product product;
    private String message;

}
