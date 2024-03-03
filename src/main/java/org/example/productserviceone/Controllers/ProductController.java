package org.example.productserviceone.Controllers;

import org.example.productserviceone.Models.Product;
import org.example.productserviceone.Services.FakeStoreProductService;
import org.example.productserviceone.Services.ProductServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

//    private Map<Integer,Integer> mp= new HashMap<>();
//    private List<Integer> li =new ArrayList<>();
    private ProductServices productServices;
    private RestTemplate restTemplate;
    public  ProductController(ProductServices productServices,RestTemplate restTemplate){
        this.productServices=productServices;
        this.restTemplate=restTemplate;
    }
    @PostMapping("/products")
    public void createProduct(){

    }
    // GET/products/1
    // GET/products/201
    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long productId){
        return productServices.getSingleProduct(productId);
    }
    @GetMapping("/products")
    public void getAllProduct(){

    }
}
