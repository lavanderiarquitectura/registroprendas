package com.laundry.clothsregisterrest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Lote {

    private Long id;

    private Integer typeOperation;

    private Integer typeFabric;

    private Boolean isFinished;

    private Integer state;

    private Integer capacity;

    public Lote(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
