package tr.com.turksat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import tr.com.turksat.entity.Personel;
import tr.com.turksat.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;
import tr.com.turksat.service.PersonelService;

import java.util.List;

@RestController
@RequestMapping("/personel")
public class PersonelRestController {

    private final PersonelService productsService;

    @Autowired
    public PersonelRestController(PersonelService theProductsService) {
        productsService = theProductsService;
    }

    @GetMapping(value = "/api/{basvuruType}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getSfProducts(@PathVariable int basvuruType) {
        return productsService.getProducts(basvuruType);
    }

    @GetMapping()
    public List<Personel> getProducts() {
        return productsService.findAll();
    }

    @PostMapping()
    public Personel addProducts(@RequestBody Personel thePersonel) {
        return productsService.save(thePersonel);
    }

    @PutMapping()
    public Personel updateProduct(@RequestBody Personel thePersonel) {
        return productsService.save(thePersonel);
    }

    @DeleteMapping("/{productId}") //parametre gondermek icin
    public String deleteProduct(@PathVariable int productId) {
        Personel tempProduct = productsService.findById(productId);
        if(tempProduct == null) throw new NotFoundException("Product doesn't exist " + productId);
        productsService.deleteById(productId);
        return "deleted product id is: " + productId;
    }
}
