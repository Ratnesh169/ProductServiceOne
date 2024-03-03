package org.example.productserviceone.Services;

import org.example.productserviceone.Models.Product;

import java.util.List;

public interface ProductServices {
    Product getSingleProduct(Long  productId);
    List<Product> getProduct();
}
