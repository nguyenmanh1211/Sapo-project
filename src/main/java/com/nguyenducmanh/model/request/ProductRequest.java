package com.nguyenducmanh.model.request;

import com.nguyenducmanh.annotation.Version;
import javax.validation.Valid;

@Version(field = "name",
        fieldMatch = "versionRequest")
public class ProductRequest {
    private String name;
    private String producer;
    private String image;
    @Valid

    private VersionRequest versionRequest;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VersionRequest getVersionRequest() {
        return versionRequest;
    }

    public void setVersionRequest(VersionRequest versionRequest) {
        this.versionRequest = versionRequest;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
