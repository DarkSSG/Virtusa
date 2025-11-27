package com.java.ProductInventory.dao;

import com.java.ProductInventory.model.Product;

import java.util.List;

public interface ProductDao {
    String addProductDao(Product product);
    Product searchProductDao(int productId);
    List<Product> showAllProductsDao();
    String updateProductDao(Product product);
    String deleteProductDao(int productId);
}
