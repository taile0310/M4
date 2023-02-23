package com.furama.repository;

import com.furama.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {
    @Query(nativeQuery = true, value = "select fc.cost + (af.cost * :quality) from `facility` fc\n" +
            "join `attach_facility` af where fc.id = :facilityId and af.id = :attachFacilityId")
    double getTotalMoneyAdd(@Param("quality") int quality
            , @Param("attachFacilityId") int attachFacilityId
            , @Param("facilityId") int facilityId);
}
