package com.demo.crm.model;

import java.time.LocalDateTime;

public abstract class BaseModel {

    private Long id;
    private LocalDateTime createDate;

    protected BaseModel() {
        createDate = LocalDateTime.now();
    }

    public BaseModel(Long id) {
        this.id = id;
        createDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
