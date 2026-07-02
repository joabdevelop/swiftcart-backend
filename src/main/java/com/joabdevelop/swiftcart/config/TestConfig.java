package com.joabdevelop.swiftcart.config;

import java.time.Instant;
import java.util.Arrays;
    
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joabdevelop.swiftcart.entities.Category;
import com.joabdevelop.swiftcart.entities.Order;
import com.joabdevelop.swiftcart.entities.Product;
import com.joabdevelop.swiftcart.entities.User;
import com.joabdevelop.swiftcart.entities.enums.OrderStatus;

import com.joabdevelop.swiftcart.repositories.CategoryRepository;
import com.joabdevelop.swiftcart.repositories.OrderRepository;
import com.joabdevelop.swiftcart.repositories.ProductRepository;
import com.joabdevelop.swiftcart.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public TestConfig(
            UserRepository userRepository,
            OrderRepository orderRepository,
            CategoryRepository categoryRepository,
            ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

        User u1 = new User(null, "Maria Brown", "[EMAIL_ADDRESS]", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "[EMAIL_ADDRESS]", "988888888", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(null, Instant.parse("2022-06-20T20:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2022-06-25T03:12:41Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2022-07-05T20:19:12Z"), OrderStatus.DELIVERED, u1);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Apple TV", 1000.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Apple Macbook Pro", 1990.5, "");
        Product p4 = new Product(null, "PC Gamer", "ASUS ROG", 3990.5, "");
        Product p5 = new Product(null, "Rails for Dummies", "Learn Ruby on Rails", 20.5, "");

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }
}
