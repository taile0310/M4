package com.furama.repository;

import com.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    //    phân trang list và search


    @Query(value = "select * from Customer where name like concat('%',:name,'%') and email" +
            " like concat('%',:searchEmail,'%')" +
            " and customer_type like concat('%',:customerType,'%')", nativeQuery = true)
    Page<Customer> findByNameContainingAndEmailContainingAndCustomerType( @Param("name") String name,@Param("searchEmail") String email,@Param("customerType") String customerType,Pageable pageable);

}
