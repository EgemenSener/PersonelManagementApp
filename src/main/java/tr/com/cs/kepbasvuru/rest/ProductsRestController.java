package tr.com.cs.kepbasvuru.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import tr.com.cs.kepbasvuru.entity.bireysel.Products;
import tr.com.cs.kepbasvuru.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;
import tr.com.cs.kepbasvuru.service.ProductsService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsRestController {

    private final ProductsService productsService;

    @Autowired
    public ProductsRestController(ProductsService theProductsService) {
        productsService = theProductsService;
    }

    @GetMapping(value = "/api/{basvuruType}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getSfProducts(@PathVariable int basvuruType) {
        return productsService.getProducts(basvuruType);
    }

    @GetMapping()
    public List<Products> getProducts() {
        return productsService.findAll();
    }

    @PostMapping()
    public Products addProducts(@RequestBody Products theProducts) {
        return productsService.save(theProducts);
    }

    @PutMapping()
    public Products updateProduct(@RequestBody Products theProduct) {
        return productsService.save(theProduct);
    }

    @DeleteMapping("/{productId}") //parametre gondermek icin
    public String deleteProduct(@PathVariable int productId) {
        Products tempProduct = productsService.findById(productId);
        if(tempProduct == null) throw new NotFoundException("Product doesn't exist " + productId);
        productsService.deleteById(productId);
        return "deleted product id is: " + productId;
    }
}
