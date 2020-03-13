package com.nguyenducmanh.model.request;

import java.util.List;

public class VersionRequest {
    private String nameVersion;
    private String image;
    private long amount;
    private List<OptionRequest> optionsRequests;

    public String getNameVersion() {
        return nameVersion;
    }

    public void setNameVersion(String nameVersion) {
        this.nameVersion = nameVersion;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<OptionRequest> getOptionsRequests() {
        return optionsRequests;
    }

    public void setOptionsRequests(List<OptionRequest> optionsRequests) {
        this.optionsRequests = optionsRequests;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
