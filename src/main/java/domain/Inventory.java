package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Inventory {
    public static List<Product> sortInventory(List<Product> products, String sortKey, boolean ascending) {
        Comparator<Product> comparator;
        switch (sortKey) {
            case "name":
                comparator = Comparator.comparing(product -> product.name);
                break;
            case "price":
                comparator = Comparator.comparingDouble(product -> product.price);
                break;
            case "stock":
                comparator = Comparator.comparingInt(product -> product.stock);
                break;
            default:
                throw new IllegalArgumentException("Invalid sort key: " + sortKey);
        }

        if (!ascending) {
            comparator = comparator.reversed();
        }

        products.sort(comparator);
        return products;
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product A", 100, 5));
        products.add(new Product("Product B", 200, 3));
        products.add(new Product("Product C", 50, 10));

        List<Product> sortedProducts = sortInventory(products, "price", true);
        sortedProducts.forEach(System.out::println);
    }
}
