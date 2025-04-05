import java.util.*;
import java.util.stream.Collectors;
class Product {
    String name;
    String category;
    double price;
    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
    public String toString() {
        return name + " (Rs " + price + ")";
    }
}
public class ProcessingDatasetsUsingStreams{
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 98500.50),
                new Product("Phone", "Electronics", 28500.75),
                new Product("TV", "Electronics", 75000.00),
                new Product("Sofa", "Furniture", 2500.25),
                new Product("Table", "Furniture", 800.99),
                new Product("Chair", "Furniture", 520.50),
                new Product("Shirt", "Clothing", 999.99),
                new Product("Jeans", "Clothing", 1599.75),
                new Product("Jacket", "Clothing", 2269.00)
        );
        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));
        System.out.println("Products Grouped by Category:");
        groupedByCategory.forEach((category, productList) ->
                System.out.println(category + " -> " + productList));
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
                ));
        System.out.println("\nMost Expensive Product in Each Category:");
        mostExpensiveByCategory.forEach((category, product) ->
                System.out.println(category + " -> " + product.orElse(null)));
        double avgPrice = products.stream()
                .mapToDouble(p -> p.price)
                .average()
                .orElse(0.0);
        System.out.println("\nAverage Price of All Products: Rs " + avgPrice);
    }

}