package org.example.productserviceone.Services;

import org.example.productserviceone.Dtos.FakeStoreProductDto;
import org.example.productserviceone.Models.Category;
import org.example.productserviceone.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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
    public  Product createProduct(String title,
                                  String description,
                                  String category,
                                  double price,
                                  String image){
        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setPrice(price);
        FakeStoreProductDto responce=restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductDto,
                FakeStoreProductDto.class
        );
        return responce.toProduct();
    }

    public List<Category> getCategories(){
        List<String> restTemplateForObject =restTemplate.getForObject(
                "https://fakestoreapi.com/products/categories",List.class
        );
        List<Category> categoryList=new ArrayList<>();
        if(restTemplateForObject != null) {
            for (var res : restTemplateForObject) {
                Category category = new Category();
                category.setTitle(res);
                categoryList.add(category);
            }
        }
        return categoryList;
    }
}
