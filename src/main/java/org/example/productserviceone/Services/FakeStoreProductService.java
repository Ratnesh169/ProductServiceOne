package org.example.productserviceone.Services;

import org.example.productserviceone.Dtos.FakeStoreProductDto;
import org.example.productserviceone.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductServices{
    private RestTemplate restTemplate;
    public  FakeStoreProductService (RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    @Override
    public Product getSingleProduct(Long productId) {
        FakeStoreProductDto fakeStoreProductDto=restTemplate.getForObject(
            "https://fakestoreapi.com/products/" +productId, FakeStoreProductDto.class
        );
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public List<Product> getProduct() {
        return null;
    }
}
