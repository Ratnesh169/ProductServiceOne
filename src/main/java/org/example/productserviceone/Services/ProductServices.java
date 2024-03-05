package org.example.productserviceone.Services;

import org.example.productserviceone.Models.Category;
import org.example.productserviceone.Models.Product;

import java.util.List;

public interface ProductServices {
    Product getSingleProduct(Long  productId);
    List<Product> getProduct();
    Product createProduct(String title,
                          String description,
                          String category,
                          double price,
                          String image);
    List<Category> getCategories();
}
