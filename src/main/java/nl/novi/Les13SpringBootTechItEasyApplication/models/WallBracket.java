package nl.novi.Les13SpringBootTechItEasyApplication.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.novi.Les13SpringBootTechItEasyApplication.dtos.TelevisionDto;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="wall_brackets")
public class WallBracket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String size;
    private Boolean adjustable;
    private String name;
    private Double price;
    // Voor elk van deze modellen bevat je applicatie ook een Repository, Controller, Dto, InputDto en een Service.
    @ManyToMany(mappedBy = "wallBrackets") //project
    @JsonIgnore
    List<Television> televisions;
    public WallBracket(Long id, String size, Boolean adjustable, String name, Double price) {
        this.id = id;
        this.size = size;
        this.adjustable = adjustable;
        this.name = name;
        this.price = price;
    }


    public WallBracket() {
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

    public List<Television> getTelevisions() {
        return televisions;
    }

    public void setTelevisions(List<Television> televisions) {
        this.televisions = televisions;
    }
}
