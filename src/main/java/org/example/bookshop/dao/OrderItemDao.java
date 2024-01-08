package org.example.bookshop.dao;

import org.example.bookshop.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemDao extends JpaRepository<OrderItem,Integer> {
}
