package com.nguyenducmanh.model.request;

public class ProductRequest {
    private String name;
    private String producer;
    private String image;
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
