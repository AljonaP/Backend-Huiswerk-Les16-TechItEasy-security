package nl.novi.Les13SpringBootTechItEasyApplication.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.novi.Les13SpringBootTechItEasyApplication.models.Television;

import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Set;

public class WallBracketDto {
    private Long id;
    private String size;
    private Boolean adjustable;
    private String name;
    private Double price;

//    @JsonSerialize
//    @JsonIgnore
//    private List<TelevisionDto> televisionDtos;

    public WallBracketDto(){
    }


    public WallBracketDto(Long id, String size, Boolean adjustable, String name, Double price) {
        this.id = id;
        this.size = size;
        this.adjustable = adjustable;
        this.name = name;
        this.price = price;
    }

    public WallBracketDto(Long id, String size, Boolean adjustable, String name, Double price, List<TelevisionDto> televisionDtos) {
        this.id = id;
        this.size = size;
        this.adjustable = adjustable;
        this.name = name;
        this.price = price;
//        this.televisionDtos = televisionDtos;

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

    public void setAdjustable(Boolean ajustable) {
        this.adjustable = ajustable;
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

//    public List<TelevisionDto> getTelevisionDtos() {
//        return televisionDtos;
//    }
//
//    public void setTelevisionDtos(List<TelevisionDto> televisionDtos) {
//        this.televisionDtos = televisionDtos;
//    }

    @Override
    public String toString() {
        return "WallBracketDto{" +
                "id=" + id +
                ", size='" + size + '\'' +
                ", adjustable='" + adjustable + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
