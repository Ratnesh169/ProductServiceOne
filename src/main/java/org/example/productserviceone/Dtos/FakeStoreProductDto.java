package org.example.productserviceone.Dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.productserviceone.Models.Category;
import org.example.productserviceone.Models.Product;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private  String title;
    private  String image;
    private String description;
    private  String category;
    private  double price;
    public Product toProduct(){
        Product product=new Product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);
        Category productCategory =new Category();
        productCategory.setTitle(title);
        product.setCategory(productCategory);
        return  product;

    }
}
