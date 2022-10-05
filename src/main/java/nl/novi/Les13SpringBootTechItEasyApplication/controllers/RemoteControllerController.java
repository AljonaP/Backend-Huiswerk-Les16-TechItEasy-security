package nl.novi.Les13SpringBootTechItEasyApplication.controllers;


import nl.novi.Les13SpringBootTechItEasyApplication.dtos.RemoteControllerDto;
import nl.novi.Les13SpringBootTechItEasyApplication.dtos.RemoteControllerInputDto;
import nl.novi.Les13SpringBootTechItEasyApplication.exceptions.RecordNotFoundException;
import nl.novi.Les13SpringBootTechItEasyApplication.models.RemoteController;
import nl.novi.Les13SpringBootTechItEasyApplication.repositories.RemoteControllerRepository;
import nl.novi.Les13SpringBootTechItEasyApplication.services.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class RemoteControllerController {
    public final RemoteControllerRepository remoteControllerRepository;

    public final RemoteControllerService remoteControllerService;


    public RemoteControllerController(RemoteControllerRepository remoteControllerRepository, RemoteControllerService remoteControllerService) {
        this.remoteControllerRepository = remoteControllerRepository;
        this.remoteControllerService = remoteControllerService;
    }

    @GetMapping("/remote-controllers")
    public ResponseEntity<List<RemoteController>> getAllRemoteControllers() {
        return ResponseEntity.ok().body(remoteControllerService.getRemoteControllers());
    }

    @GetMapping("/remote-controllers/{id}")
    public ResponseEntity<Object> getRemoteController(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(remoteControllerService.getRemoteControllerById(id));
    }

    @PostMapping("/remote-controllers")
    public ResponseEntity<Object> addRemoteController(@Valid @RequestBody RemoteControllerInputDto remoteControllerInputDto) {
        RemoteControllerDto dto = remoteControllerService.saveRemoteController(remoteControllerInputDto);
        return ResponseEntity.created(null).body(dto);
    }

    @PutMapping("/remote-controllers/{id}")
    public ResponseEntity<Object> updateRemoteController(@PathVariable Long id, @RequestBody RemoteControllerInputDto remoteController) {
        RemoteControllerDto updateRemoteController = remoteControllerService.updateRemoteController(remoteController, id);
        return ResponseEntity.ok(updateRemoteController);
    }

    @DeleteMapping("/remote-controllers/{id}")
    public void deleteRemoteController(@PathVariable Long id) {
        remoteControllerService.deleteRemoteController(id);
    }

    @GetMapping("/remote-controllers/brands")
    @ResponseBody
    public ResponseEntity<Object> getRemoteControllersByBrand(@RequestParam String brand) {
        if (brand == null) {
            throw new RecordNotFoundException("No brand is filled out. Try again.");
        }
        List<RemoteController> remoteControllerByBrand = remoteControllerRepository.getAllRemoteControllersByBrand(brand);
        return ResponseEntity.ok().body(remoteControllerByBrand);
    }
}
