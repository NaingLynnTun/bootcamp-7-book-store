package org.example.bookshop.dao;

import org.example.bookshop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
}
