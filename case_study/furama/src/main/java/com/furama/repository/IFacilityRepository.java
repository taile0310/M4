package com.furama.repository;

import com.furama.model.customer.Customer;
import com.furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    Page<Facility> findByNameContaining(String name, Pageable pageable);
}
