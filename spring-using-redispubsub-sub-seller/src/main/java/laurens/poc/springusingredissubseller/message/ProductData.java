package laurens.poc.springusingredissubseller.message;

import laurens.poc.springusingredissubseller.entities.Product;
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