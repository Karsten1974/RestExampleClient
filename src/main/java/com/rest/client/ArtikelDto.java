package com.rest.client;

import javax.validation.constraints.NotNull;

public class ArtikelDto extends ArtikelCreateDto {
    @NotNull
    private Integer id;
    
    private int version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
