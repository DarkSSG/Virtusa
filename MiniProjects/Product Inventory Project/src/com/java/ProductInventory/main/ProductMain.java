package com.java.ProductInventory.main;

import com.java.ProductInventory.bal.ProductBal;
import com.java.ProductInventory.exception.ProductException;
import com.java.ProductInventory.model.Product;

import java.util.List;
import java.util.Scanner;

public class ProductMain {
    static Scanner sc;
    static ProductBal productBal;
    static {
        productBal = new ProductBal();
        sc = new Scanner(System.in);
    }

    public static void showProductMain() {
        List<Product> productList = productBal.showProductBal();
        productList.forEach(System.out::println);
    }

    public static void addProductMain() throws ProductException {
        Product product = new Product();

        System.out.println("Enter Product ID: ");
        product.setProductId(sc.nextInt());

        System.out.println("Enter Product Name: ");
        sc.nextLine();
        product.setProductName(sc.nextLine());

        System.out.println("Enter Product Price: ");
        product.setPrice(sc.nextDouble());

        System.out.println("Enter Product Quantity: ");
        product.setQuantity(sc.nextInt());

        System.out.println("Enter Product Category: ");
        sc.nextLine();
        product.setCategory(sc.nextLine());

        System.out.println(productBal.addProductBal(product));
    }

    public static void searchProductMain() {
        System.out.println("Enter Product ID: ");
        int productId = sc.nextInt();
        Product product = productBal.searchProductBal(productId);
        if (product != null) {
            System.out.println(product);
        }
        else {
            System.out.println("Product Details for Product ID " +productId +"Not Found.");
        }
    }

    public static void updateProductMain() {
        Product productUpdate = new Product();

        System.out.println("Enter Product ID: ");
        productUpdate.setProductId(sc.nextInt());

        System.out.println("Enter Product Name: ");
        sc.nextLine();
        productUpdate.setProductName(sc.nextLine());

        System.out.println("Enter Product Price: ");
        productUpdate.setPrice(sc.nextDouble());

        System.out.println("Enter Product Quantity: ");
        productUpdate.setQuantity(sc.nextInt());

        System.out.println("Enter Product Category: ");
        sc.nextLine();
        productUpdate.setCategory(sc.nextLine());

        try {
            System.out.println(productBal.updateProductBal(productUpdate));
        } catch (ProductException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void deleteProductMain() {
        System.out.println("Enter Product ID: ");
        int productId = sc.nextInt();
        System.out.println(productBal.deleteProductBal(productId));
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("O P T I O N S: ");
            System.out.println("1. Add Product Details");
            System.out.println("2. Show All Products in the Inventory");
            System.out.println("3. Show Product Details");
            System.out.println("4. Update Product Details");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit Menu");

            System.out.println("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    try {
                        addProductMain();
                    } catch (ProductException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    showProductMain();
                    break;
                case 3:
                    searchProductMain();
                    break;
                case 4:
                    updateProductMain();
                    break;
                case 5:
                    deleteProductMain();
                    break;
                case 6:
                    System.exit(0);
            }
        }while(true);
    }
}
