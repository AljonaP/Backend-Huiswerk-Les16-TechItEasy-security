package nl.novi.Les11SpringBootTechItEasyApplication.controllers;

import nl.novi.Les11SpringBootTechItEasyApplication.exceptions.RecordNotFoundException;
import nl.novi.Les11SpringBootTechItEasyApplication.models.Television;
import nl.novi.Les11SpringBootTechItEasyApplication.repositories.TelevisionRepository;
import nl.novi.Les11SpringBootTechItEasyApplication.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<Object> add(@RequestBody Television television) {
        Television returnTelevision = televisionService.saveTelevision(television);
        return ResponseEntity.created(null).body(returnTelevision);
    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable Long id, @RequestBody Television television) {
        Television updateTelevision = televisionService.updateTelevision(id).orElseThrow(() -> new RecordNotFoundException("Television doesn't exist with the id: " + id));
        updateTelevision.setId(television.getId());
        updateTelevision.setType(television.getType());
        updateTelevision.setBrand(television.getBrand());
        updateTelevision.setName(television.getName());
        updateTelevision.setPrice(television.getPrice());
        updateTelevision.setAvailableSize(television.getAvailableSize());
        updateTelevision.setRefreshRate(television.getRefreshRate());
        updateTelevision.setScreenType(television.getScreenType());
        updateTelevision.setScreenQuality(television.getScreenQuality());
        updateTelevision.setSmartTv(television.getSmartTv());
        updateTelevision.setWifi(television.getWifi());
        updateTelevision.setVoiceControl(television.getVoiceControl());
        updateTelevision.setHdr(television.getHdr());
        updateTelevision.setBluetooth(television.getBluetooth());
        updateTelevision.setAmbiLight(television.getAmbiLight());
        updateTelevision.setOriginalStock(television.getOriginalStock());
        updateTelevision.setSold(television.getSold());

        televisionService.saveTelevision(updateTelevision);
        return ResponseEntity.ok(updateTelevision);
    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
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

