package com.example.session15.service;

import com.example.session15.model.dto.request.OrderItemRequest;
import com.example.session15.model.entity.*;
import com.example.session15.repository.OrderRepository;
import com.example.session15.repository.ProductRepository;
import com.example.session15.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Order createOrder(List<OrderItemRequest> items, String email) {

        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Order order = new Order();
        order.setUser(user);
        order.setCreatedDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);

        List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (OrderItemRequest i : items) {

            // ✅ Validate quantity
            if (i.getQuantity() <= 0) {
                throw new RuntimeException("Quantity must be > 0");
            }

            Product p = productRepository.findById(i.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderItem oi = new OrderItem();
            oi.setOrder(order);
            oi.setProduct(p);
            oi.setQuantity(i.getQuantity());

            //
            oi.setPriceBuy(p.getPrice());

            BigDecimal itemTotal = p.getPrice()
                    .multiply(BigDecimal.valueOf(i.getQuantity()));

            total = total.add(itemTotal);
            orderItems.add(oi);
        }

        order.setItems(orderItems);

        // ✅ format tiền (2 chữ số thập phân)
        order.setTotalMoney(total.setScale(2, RoundingMode.HALF_UP));

        return orderRepository.save(order);
    }

    public List<Order> getMyOrders(String email) {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return orderRepository.findByUser(user);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateStatus(Long id, OrderStatus status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }
}