package laurens.poc.springusingredispub.controller;

import laurens.poc.springusingredispub.entities.Product;
import laurens.poc.springusingredispub.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> getProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") int idProduct){
         return ResponseEntity.status(HttpStatus.OK).body(productService.getProductByid(idProduct));
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") int idProduct){
        return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(idProduct));
    }

    @PatchMapping(path = "/product/{id}")
    public ResponseEntity<?> modifyProduct(@PathVariable("id") int idProduct, @RequestBody Product product){
        return ResponseEntity.status(HttpStatus.OK).body(productService.modifyProduct(idProduct, product));
    }

}
