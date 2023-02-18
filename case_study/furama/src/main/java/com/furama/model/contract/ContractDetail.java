package com.furama.model.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)

    private int id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "contractId", referencedColumnName = "id")
    private Contract contractId;
    @ManyToOne
    @JoinColumn(name = "attachFacilityId",referencedColumnName = "id")
    private AttachFacility attachFacilityId;

    public ContractDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contract getContractId() {
        return contractId;
    }

    public void setContractId(Contract contractId) {
        this.contractId = contractId;
    }

    public void setAttachFacilityId(AttachFacility attachFacilityId) {
        this.attachFacilityId = attachFacilityId;
    }

}
