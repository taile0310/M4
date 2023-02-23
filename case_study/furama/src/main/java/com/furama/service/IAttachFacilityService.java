package com.furama.service;

import com.furama.model.contract.AttachFacility;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> getListAttachFacility();

    double getTotalMoneyAdd(@RequestParam("quality") int quality
            , @RequestParam("attachFacilityId") int attachFacilityId
            , @RequestParam("facilityId") int facilityId);
}
