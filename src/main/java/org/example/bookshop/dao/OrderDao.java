package org.example.bookshop.dao;

import org.example.bookshop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order,Integer> {
}
