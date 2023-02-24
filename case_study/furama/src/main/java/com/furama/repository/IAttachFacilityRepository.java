package com.furama.repository;

import com.furama.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {

    @Query(nativeQuery = true, value = "select f.cost + (af.cost * :quantity) from `facility` f" +
            "join `attach_facility` af where f.id = :facility and af.id = :attachFacility")

    double getTotalMoneyAdd(@Param("quantity") int quantity
            , @Param("attachFacility") int attachFacility
                , @Param("facility") int facility);

    @Query(nativeQuery = true, value = "select facility.cost from facility where facility.id = :facilityId")
    double getCostFacility(@Param("facilityId") int facilityId);
}
