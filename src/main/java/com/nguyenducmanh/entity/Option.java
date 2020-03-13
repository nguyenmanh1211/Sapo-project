package com.nguyenducmanh.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "optional")
public class Option extends Base {
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private String value;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "version_id")
    private Version version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }
}
