package com.laundry.clothsregisterrest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Lote {

    private Long id;

    private String typeService;

    private Integer typeOperation;

    private Integer typeFabric;

    private Boolean isFinished;

    private Integer capacity;

    public Lote(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public Integer getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(Integer typeOperation) {
        this.typeOperation = typeOperation;
    }

    public Integer getTypeFabric() {
        return typeFabric;
    }

    public void setTypeFabric(Integer typeFabric) {
        this.typeFabric = typeFabric;
    }

    public Boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Boolean finished) {
        isFinished = finished;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
