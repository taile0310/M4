package com.furama.repository;

import com.furama.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
    //    phân trang list và search
    Page<CustomerType> findByNameContaining(String name, Pageable pageable);
}
