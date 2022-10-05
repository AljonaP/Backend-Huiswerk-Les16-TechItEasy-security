package nl.novi.Les13SpringBootTechItEasyApplication.controllers;

import nl.novi.Les13SpringBootTechItEasyApplication.dtos.CIModuleDto;
import nl.novi.Les13SpringBootTechItEasyApplication.dtos.CIModuleInputDto;
import nl.novi.Les13SpringBootTechItEasyApplication.models.CIModule;
import nl.novi.Les13SpringBootTechItEasyApplication.repositories.CIModuleRepository;
import nl.novi.Les13SpringBootTechItEasyApplication.services.CIModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CIModulesController {
    public final CIModuleRepository ciModuleRepository;

    public final CIModuleService ciModuleService;

    public CIModulesController(CIModuleRepository ciModuleRepository, CIModuleService ciModuleService) {
        this.ciModuleRepository = ciModuleRepository;
        this.ciModuleService = ciModuleService;
    }

    @GetMapping("/ci-modules")
    public ResponseEntity<List<CIModule>> getAllCIModules() {
        return ResponseEntity.ok().body(ciModuleService.getCIModules());
    }

    @GetMapping("/ci-modules/{id}")
    public ResponseEntity<Object> getCIModules(@PathVariable(name="id") Long id) {
        return ResponseEntity.ok(ciModuleService.getCIModuleById(id));
    }

    @PostMapping("/ci-modules")
    public ResponseEntity<Object> addCIModule(@Valid @RequestBody CIModuleInputDto ciModuleInputDto ) {
        CIModuleDto dto = ciModuleService.saveCIModule(ciModuleInputDto);
        return ResponseEntity.created(null).body(dto);
    }

    @PutMapping("/ci-modules/{id}")
    public ResponseEntity<Object> updateCIModule(@PathVariable Long id, @RequestBody CIModuleInputDto ciModule) {
        CIModuleDto updateCIModule = ciModuleService.updateCIModule(ciModule, id);
        return ResponseEntity.ok(updateCIModule);
    }

    @DeleteMapping("/ci-modules/{id}")
    public void deleteCIModule(@PathVariable Long id) {
        ciModuleService.deleteCIModule(id);
    }



}
