package nl.novi.Les13SpringBootTechItEasyApplication.controllers;

import nl.novi.Les13SpringBootTechItEasyApplication.dtos.WallBracketDto;
import nl.novi.Les13SpringBootTechItEasyApplication.dtos.WallBracketInputDto;
import nl.novi.Les13SpringBootTechItEasyApplication.models.WallBracket;
import nl.novi.Les13SpringBootTechItEasyApplication.repositories.WallBracketRepository;
import nl.novi.Les13SpringBootTechItEasyApplication.services.WallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class WallBracketsController {
    public final WallBracketRepository wallBracketRepository;

    public final WallBracketService wallBracketService;

    public WallBracketsController(WallBracketRepository wallBracketRepository, WallBracketService wallBracketService) {
        this.wallBracketRepository = wallBracketRepository;
        this.wallBracketService = wallBracketService;
    }


    @GetMapping("/wall-brackets")
    public ResponseEntity<List<WallBracketDto>> getAllWallBrackets() {
        return ResponseEntity.ok().body(wallBracketService.getWallBrackets());
    }

    @GetMapping("/wall-brackets/{id}")
    public ResponseEntity<Object> getWallBrackets(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(wallBracketService.getWallBracketById(id));
    }

    @PostMapping("/wall-brackets")
    public ResponseEntity<Object> addWallBracket(@Valid @RequestBody WallBracketInputDto wallBracketInputDto) {
        WallBracketDto dto = wallBracketService.saveWallBracket(wallBracketInputDto);
        return ResponseEntity.created(null).body(dto);

    }

    @PutMapping("/wall-brackets/{id}")
    public ResponseEntity<Object> updateWallBracket(@PathVariable Long id, @RequestBody WallBracketInputDto wallBracket) {
        WallBracketDto updateWallBracket = wallBracketService.updateWallBracket(wallBracket, id);
        return ResponseEntity.ok(updateWallBracket);
    }

    @DeleteMapping("/wall-brackets/{id}")
    public void deleteWallBracket(@PathVariable Long id) {
        wallBracketService.deleteWallBracket(id);
    }
}
