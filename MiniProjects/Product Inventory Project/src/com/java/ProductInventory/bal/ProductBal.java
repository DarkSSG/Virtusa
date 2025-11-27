package com.java.ProductInventory.bal;

import com.java.ProductInventory.dao.ProductDao;
import com.java.ProductInventory.dao.ProductDaoImplementation;
import com.java.ProductInventory.exception.ProductException;
import com.java.ProductInventory.model.Product;

import java.util.List;

public class ProductBal {
    static StringBuilder sb;
    static ProductDao productDao;

    static {
        sb = new StringBuilder();
        productDao = new ProductDaoImplementation();
    }

    public List<Product> showProductBal() {
        return productDao.showAllProductsDao();
    }

    public Product searchProductBal(int productId) {
        return productDao.searchProductDao(productId);
    }

    public String deleteProductBal(int productId) {
        return productDao.deleteProductDao(productId);
    }

    public String addProductBal (Product product) throws ProductException{
        if (productDao.searchProductDao(product.getProductId()) != null) {
            throw new ProductException("Product ID already exists!!!");
        }
        if (validProduct(product)) {
            return productDao.addProductDao(product);
        }
        throw new ProductException(sb.toString());
    }

    public String updateProductBal (Product productUpdate) throws ProductException {
        if (productDao.searchProductDao(productUpdate.getProductId()) == null) {
            throw new ProductException("Product does not exist in the Inventory.");
        }
        if (validProduct(productUpdate)) {
            return productDao.updateProductDao(productUpdate);
        }
        throw new ProductException(sb.toString());
    }

    private boolean validProduct(Product product) {
        sb.setLength(0);
        boolean isValid = true;
        String productName = product.getProductName();
        double productPrice = product.getPrice();
        int productQuantity = product.getQuantity();
        String category = product.getCategory();

        if (productName == null || productName.trim().isEmpty() || productName.length() < 5){
            sb.append("Product Name cannot be Null or be less then 5 Characters!");
            isValid = false;
        }

        if (productPrice <= 0) {
            sb.append("Product price cannot be 0 or less than 0!");
            isValid = false;
        }

        if (productQuantity < 0) {
            sb.append("Product Quantity cannot be less then 0!");
            isValid = false;
        }

        if (category == null || category.trim().isEmpty() || category.length() < 3) {
            sb.append("Product Category cannot be Null or be less then 3 Characters!")  ;
            isValid = false;
        }

        return isValid;
    }
}
