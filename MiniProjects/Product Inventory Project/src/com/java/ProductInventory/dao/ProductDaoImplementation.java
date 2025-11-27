package com.java.ProductInventory.dao;

import com.java.ProductInventory.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImplementation implements ProductDao{
    static List<Product> productList;

    static {
        productList = new ArrayList<>();
    }


    @Override
    public String addProductDao(Product product) {
        productList.add(product);
        return "Product Added in the Inventory.";
    }

    @Override
    public Product searchProductDao(int productId) {
        return productList.stream().filter(p -> p.getProductId() == productId).findFirst().orElse(null);
    }

    @Override
    public List<Product> showAllProductsDao() {
        return productList;
    }

    @Override
    public String updateProductDao(Product productUpdate) {
        Product productFound = searchProductDao(productUpdate.getProductId());
        if (productFound != null) {
            productFound.setProductName(productUpdate.getProductName());
            productFound.setCategory(productUpdate.getCategory());
            productFound.setPrice(productUpdate.getPrice());
            productFound.setQuantity(productUpdate.getQuantity());

            return "Product Details for " +productFound.getProductId() +" Updated Successfully.";
        }
        return "Product Not Found in the Inventory.";
    }

    @Override
    public String deleteProductDao(int productId) {
        Product productFound = searchProductDao(productId);
        if (productFound != null) {
            productList.remove(productFound);
            return "Product Deleted Successfully from the Inventory.";
        }
        return "Product Details Not Found.";
    }
}
