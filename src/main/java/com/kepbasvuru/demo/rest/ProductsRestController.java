package com.kepbasvuru.demo.rest;

import com.kepbasvuru.demo.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;

import static com.kepbasvuru.demo.constants.CommonConstants.*;

@RestController
@RequestMapping("/products")
public class ProductsRestController {
    @GetMapping("/{basvuruType}")
    public String getProducts(@PathVariable int basvuruType) {
        switch (basvuruType) {
            case TYPE_BIREYSEL:
                throw new NotFoundException(TYPE_BIREYSEL + " products doesn't exist!");
            case TYPE_KURUMSAL:
                return "Kurumsal Urunler";
            case TYPE_KAMU:
                return "Kamu Urunler";
        }
        return "";
    }
}
