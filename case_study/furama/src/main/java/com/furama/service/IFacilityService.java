package com.furama.service;

import com.furama.model.customer.Customer;
import com.furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    List<Facility> getListFacility();
    void saveFacility(Facility facility);
    void deleteFacility(int id);
    Page<Facility> searchForTwoField(String name,Pageable pageable);

}
