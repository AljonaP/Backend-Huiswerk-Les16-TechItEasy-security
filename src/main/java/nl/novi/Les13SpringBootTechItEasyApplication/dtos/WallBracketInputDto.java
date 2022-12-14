package nl.novi.Les13SpringBootTechItEasyApplication.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class WallBracketInputDto {

    private Long id;
    @NotBlank
    private String size;
    private Boolean adjustable;
    private String name;
    private Double price;

    public WallBracketInputDto() {
    }

    public WallBracketInputDto(Long id, String size, Boolean adjustable, String name, Double price) {
        this.id = id;
        this.size = size;
        this.adjustable = adjustable;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable(Boolean adjustable) {
        this.adjustable = adjustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "WallBracketInputDto{" +
                "id=" + id +
                ", size='" + size + '\'' +
                ", adjustable='" + adjustable + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
