package com.furama.service.impl;

import com.furama.model.contract.Contract;
import com.furama.repository.IContractRepository;
import com.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository  contractRepository;
    @Override
    public List<Contract> getListContract() {
        return contractRepository.findAll();
    }

    @Override
    public void saveContract(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void deleteContract(int id) {
        contractRepository.deleteById(id);

    }
}
