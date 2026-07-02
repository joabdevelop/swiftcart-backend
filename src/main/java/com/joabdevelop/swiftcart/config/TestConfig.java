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
import com.joabdevelop.swiftcart.entities.OrderItem;
import com.joabdevelop.swiftcart.entities.enums.OrderStatus;
import com.joabdevelop.swiftcart.entities.Payment;

import com.joabdevelop.swiftcart.repositories.CategoryRepository;
import com.joabdevelop.swiftcart.repositories.OrderRepository;
import com.joabdevelop.swiftcart.repositories.ProductRepository;
import com.joabdevelop.swiftcart.repositories.UserRepository;
import com.joabdevelop.swiftcart.repositories.OrderItemRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;

    public TestConfig(
            UserRepository userRepository,
            OrderRepository orderRepository,
            CategoryRepository categoryRepository,
            ProductRepository productRepository,
            OrderItemRepository orderItemRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public void run(String... args) throws Exception { User u1 = new User(null, "Maria Brown", "[EMAIL_ADDRESS]", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "[EMAIL_ADDRESS]", "988888888", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(null, Instant.parse("2022-06-20T20:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2022-06-25T03:12:41Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2022-07-05T20:19:12Z"), OrderStatus.DELIVERED, u1);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Apple TV", 1000.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Apple Macbook Pro", 1990.5, "");
        Product p4 = new Product(null, "PC Gamer", "ASUS ROG", 3990.5, "");
        Product p5 = new Product(null, "Rails for Dummies", "Learn Ruby on Rails", 20.5, "");

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(c2);
        p2.getCategories().add(c1);
        p2.getCategories().add(c3);
        p3.getCategories().add(c3);
        p4.getCategories().add(c3);
        p5.getCategories().add(c2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment payment1 = new Payment(null, Instant.parse("2022-06-20T21:53:07Z"), o1);
        o1.setPayment(payment1);

        orderRepository.save(o1);

    }
}
