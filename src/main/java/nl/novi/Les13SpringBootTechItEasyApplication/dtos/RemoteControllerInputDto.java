package nl.novi.Les13SpringBootTechItEasyApplication.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RemoteControllerInputDto {
    private Long id;
    @NotBlank
    private String compatibleWith;
    @NotBlank
    private String batteryType;
    @NotBlank
    @Size(min=1, max=50)
    private String name;
    @NotBlank
    @Size(min=1, max=35)

    @NotBlank
    private String brand;
    private Double price;
    private Integer originalStock;

    public RemoteControllerInputDto(Long id, String compatibleWith, String batteryType, String name, String brand, Double price, Integer originalStock) {
        this.id = id;
        this.compatibleWith = compatibleWith;
        this.batteryType = batteryType;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.originalStock = originalStock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    @Override
    public String toString() {
        return "RemoteControllerInputDto{" +
                "id=" + id +
                ", compatibleWith ='" + compatibleWith + '\'' +
                ", batteryType ='" + batteryType + '\''+
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", originalStock=" + originalStock +
                '}';
    }
}
