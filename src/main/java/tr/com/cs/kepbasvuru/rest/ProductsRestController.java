package tr.com.cs.kepbasvuru.rest;

import org.springframework.beans.factory.annotation.Autowired;
import tr.com.cs.kepbasvuru.entity.bireysel.Products;
import tr.com.cs.kepbasvuru.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;
import tr.com.cs.kepbasvuru.service.ProductsService;

import java.util.List;

import static tr.com.cs.kepbasvuru.constants.CommonConstants.*;

@RestController
@RequestMapping("/products")
public class ProductsRestController {

    private ProductsService productsService;

    @Autowired
    public ProductsRestController(ProductsService theProductsService) {
        productsService = theProductsService;
    }

    @GetMapping("/{basvuruType}")
    public List<Products> getProducts(@PathVariable int basvuruType) {
        return switch (basvuruType) {
            case TYPE_BIREYSEL -> productsService.findAll();
            case TYPE_KURUMSAL -> throw new NotFoundException(TYPE_KURUMSAL + " products doesn't exist!");
            case TYPE_KAMU -> null;
            default -> null;
        };
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
        if(tempProduct == null) throw new NotFoundException("Product doesn' exist " + productId);
        productsService.deleteById(productId);
        return "deleted product id is: " + productId;
    }
}
