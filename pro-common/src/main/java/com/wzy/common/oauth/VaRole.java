package com.wzy.common.oauth;

import java.io.Serializable;

public class VaRole implements Serializable {
    private Integer id;
    private String name;

    public VaRole(){

    }

    public VaRole(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
