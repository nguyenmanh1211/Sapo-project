package com.nguyenducmanh.model.request;

import com.nguyenducmanh.annotation.Battery;
import com.nguyenducmanh.annotation.Camera;
import com.nguyenducmanh.annotation.Price;
import com.nguyenducmanh.annotation.Memory;

import javax.validation.constraints.NotNull;
import java.util.List;

public class VersionRequest {
    private String nameVersion;
    private String image;
    @NotNull(message = "amount must not be null")
    private long amount;
    private List<OptionRequest> optionsRequests;
    @Price
    private Integer price;
    @NotNull(message = "ram must not be null")
    private Integer ram;
    @NotNull(message = "cpu must not be null")
    private String cpu;
    @NotNull(message = "gpu must not be null")
    private String gpu;
    private String display;
    @Camera
    private String camera;
    @NotNull(message = "status must not be null")
    private Integer status;
    @Battery
    private String battery;
    @Memory
    private String memory;
    @NotNull(message = "color must not be null")
    private String color;
    private float discountRates = 1;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getDiscountRates() {
        return discountRates;
    }

    public void setDiscountRates(float discountRates) {
        this.discountRates = discountRates;
    }
}
