package nl.novi.Les10SpringBootTechItEasyApplication.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TelevisionsController {
    @GetMapping("/televisions")
    public ResponseEntity<Object> getTelevisions() {
        return ResponseEntity.ok();
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<Object> getTelevisions(@PathVariable int id) {
//        if(id>3) {
//            throw new RecordNotFoundException("id > 3");
//        }
        return ResponseEntity.ok();
    }

    @PostMapping("/televisions")
    public ResponseEntity<Object> postTelevision(@RequestBody String televisionName) {
        return ResponseEntity.created();
    }

    @PutMapping("/television/{id}")
    public ResponseEntity<Object> putTelevision(@PathVariable int id, @RequestBody String televisionName) {
        return ResponseEntity.ok();
    }

    @DeleteMapping("/television/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable int id) {
        return ResponseEntity.noContent();
    }
}

    /* een GET-request voor alle televisies
        een GET-request voor 1 televisie
        een POST-request voor 1 televisie
        een PUT-request voor 1 televisie
        een DELETE-request voor 1 televisie */


/*ResponseEntiteit.ok()
ResponseEntiteit.created()
ResponseEntiteit.noContent()*/
