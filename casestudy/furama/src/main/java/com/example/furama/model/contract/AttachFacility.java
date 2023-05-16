package com.example.furama.model.contract;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attachFacilityId;
    @Column(nullable = false,length = 45)
    private String attachFacilityName;
    @Column(nullable = false)
    private double attachFacilityCost;
    @Column(length = 10,nullable = false)
    private String attachFacilityUnit;
    @Column(length = 45,nullable = false)
    private String attachFacilityStatus;

    @OneToMany(mappedBy = "attachFacility")
    private Set<ContractDetail> contractDetail;

    public AttachFacility() {
    }

    public Integer getAttachFacilityId() {
        return attachFacilityId;
    }

    public void setAttachFacilityId(Integer attachFacilityId) {
        this.attachFacilityId = attachFacilityId;
    }

    public String getAttachFacilityName() {
        return attachFacilityName;
    }

    public void setAttachFacilityName(String attachFacilityName) {
        this.attachFacilityName = attachFacilityName;
    }

    public double getAttachFacilityCost() {
        return attachFacilityCost;
    }

    public void setAttachFacilityCost(double attachServiceCost) {
        this.attachFacilityCost = attachServiceCost;
    }

    public String getAttachFacilityUnit() {
        return attachFacilityUnit;
    }

    public void setAttachFacilityUnit(String attachServiceUnit) {
        this.attachFacilityUnit = attachServiceUnit;
    }

    public String getAttachFacilityStatus() {
        return attachFacilityStatus;
    }

    public void setAttachFacilityStatus(String attachServiceStatus) {
        this.attachFacilityStatus = attachServiceStatus;
    }

    public Set<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(Set<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }
}
