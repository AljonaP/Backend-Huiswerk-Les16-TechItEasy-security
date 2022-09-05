package nl.novi.Les11SpringBootTechItEasyApplication.controllers;

import nl.novi.Les11SpringBootTechItEasyApplication.exceptions.RecordNotFoundException;
import nl.novi.Les11SpringBootTechItEasyApplication.models.Television;
import nl.novi.Les11SpringBootTechItEasyApplication.repositories.TelevisionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.error.Mark;

import java.util.List;

@RestController
public class TelevisionsController {

    // De onderstaande regel is i.p.v. @Autowired.
// Dit is een moderner manier om te schrijven:
    public final TelevisionRepository televisionRepository;

    //constructor
    public TelevisionsController(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository; //'this' verwijs naar public final Television televisionRepository. Wat na '=' staat is een parameter van TelevisionController
    }

    @GetMapping("/televisions")
    public ResponseEntity<List<Television>> getAllTelevisions() {
        return ResponseEntity.ok().body(televisionRepository.findAll());
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<Object> getTelevisions(@PathVariable(name = "id") Long id) {
//        if(id>3) {
//            throw new RecordNotFoundException("id > 3");
//        }
        return ResponseEntity.ok(televisionRepository.findById(id));
    }

    @PostMapping("/televisions")
    public ResponseEntity<Object> add(@RequestBody Television television) {
        Television returnTelevision = televisionRepository.save(television);
        return ResponseEntity.created(null).body(returnTelevision);
    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable Long id, @RequestBody Television television) {
        Television updateTelevision = televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Television doesn't exist with the id: " + id));
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

        televisionRepository.save(updateTelevision);
        return ResponseEntity.ok(updateTelevision);
    }
    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable Long id) {
//        Television television = televisionRepository.findById(id).get();
//        televisionRepository.delete(television);
        televisionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/televisions/brands")
    @ResponseBody
    public ResponseEntity<Object> getTelevisionsByBrand(@RequestParam String brand) {
        if (brand == null) {
            throw new RecordNotFoundException("Typed brand doesn't exist. Try again or choose another brand.");
        }
        televisionRepository.findAll(brand);
        return ResponseEntity.ok().build();
    }
}

