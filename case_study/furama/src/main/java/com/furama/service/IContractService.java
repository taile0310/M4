package com.furama.service;

import com.furama.model.contract.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> getListContract();
    void saveContract(Contract contract);
    void deleteContract(int id);
}
