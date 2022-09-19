package nl.novi.Les12SpringBootTechItEasyApplication.controllers;
import nl.novi.Les12SpringBootTechItEasyApplication.dtos.TelevisionDto;
import nl.novi.Les12SpringBootTechItEasyApplication.dtos.TelevisionInputDto;
import nl.novi.Les12SpringBootTechItEasyApplication.exceptions.RecordNotFoundException;
import nl.novi.Les12SpringBootTechItEasyApplication.models.Television;
import nl.novi.Les12SpringBootTechItEasyApplication.repositories.TelevisionRepository;
import nl.novi.Les12SpringBootTechItEasyApplication.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TelevisionsController {
    public final TelevisionRepository televisionRepository;

    public final TelevisionService televisionService;
    public TelevisionsController(TelevisionRepository televisionRepository, TelevisionService televisionService) {
        this.televisionRepository = televisionRepository; //'this' verwijs naar public final Television televisionRepository. Wat na '=' staat is een parameter van TelevisionController
        this.televisionService =  televisionService;
    }

    @GetMapping("/televisions")
    public ResponseEntity<List<Television>> getAllTelevisions() {
        return ResponseEntity.ok().body(televisionService.getTelevisions());
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<Object> getTelevisions(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(televisionService.getTelevisionById(id));
    }

    @PostMapping("/televisions")
    public ResponseEntity<Object> addTelevision(@Valid @RequestBody TelevisionInputDto televisionInputDto) {
        TelevisionDto dto = televisionService.saveTelevision(televisionInputDto);
        return ResponseEntity.created(null).body(dto);
    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable Long id, @RequestBody TelevisionInputDto television) {
        TelevisionDto updateTelevision = televisionService.updateTelevision(television, id);
         return ResponseEntity.ok(updateTelevision);
    }

    @DeleteMapping("/televisions/{id}")
    public void deleteTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
    }

    @GetMapping("/televisions/brands")
    @ResponseBody
    public ResponseEntity<Object> getTelevisionsByBrand(@RequestParam String brand) {
        if (brand == null) {
            throw new RecordNotFoundException("No brand is filled out. Try again.");
        }
        List<Television> televisionByBrand = televisionRepository.getAllTelevisionsByBrand(brand);
        return ResponseEntity.ok().body(televisionByBrand);
    }
}

