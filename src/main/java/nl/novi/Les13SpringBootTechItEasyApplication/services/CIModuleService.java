package nl.novi.Les13SpringBootTechItEasyApplication.services;

import nl.novi.Les13SpringBootTechItEasyApplication.dtos.CIModuleDto;
import nl.novi.Les13SpringBootTechItEasyApplication.dtos.CIModuleInputDto;
import nl.novi.Les13SpringBootTechItEasyApplication.dtos.TelevisionDto;
import nl.novi.Les13SpringBootTechItEasyApplication.exceptions.RecordNotFoundException;
import nl.novi.Les13SpringBootTechItEasyApplication.models.CIModule;
import nl.novi.Les13SpringBootTechItEasyApplication.models.RemoteController;
import nl.novi.Les13SpringBootTechItEasyApplication.models.Television;
import nl.novi.Les13SpringBootTechItEasyApplication.repositories.CIModuleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CIModuleService {

    private final CIModuleRepository ciModuleRepository;

    public CIModuleService(CIModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }

    public List<CIModule> getCIModules(){
        return ciModuleRepository.findAll();
    }

    public CIModuleDto getCIModuleById(Long id) {
        if(ciModuleRepository.findById(id).isPresent()){
            CIModule ciModule = ciModuleRepository.findById(id).get();
            return fromCIModule(ciModule);
        } else {
            throw new RecordNotFoundException("The entered value isn't correct or doesn't exist. Search again with another value.");
        }
    }

    public CIModuleDto saveCIModule(CIModuleInputDto dto) {
        CIModule ciModule = toCIModule(dto);
        ciModuleRepository.save(ciModule);
        return fromCIModule(ciModule);
    }

    public CIModuleDto updateCIModule(CIModuleInputDto inputDto, Long id) {
        CIModule ciModule = ciModuleRepository.findById(id).orElseThrow(() -> {throw new RecordNotFoundException("CI-module with this id doesn't exist. Try another Id.");});

        if(!ciModule.getId().equals(inputDto.getId())) {
            ciModule.setId(inputDto.getId());
        }

        if (!ciModule.getType().equals(inputDto.getType())) {
            ciModule.setType(inputDto.getType());
        }

        if (!ciModule.getName().equals(inputDto.getName())) {
            ciModule.setName(inputDto.getName());
        }

        if (!ciModule.getPrice().equals(inputDto.getPrice())) {
            ciModule.setPrice(inputDto.getPrice());
        }

        ciModuleRepository.save(ciModule);

        return fromCIModule(ciModule);
    }

    public void deleteCIModule(@RequestBody Long id){
        ciModuleRepository.deleteById(id);
    }

    public static CIModule toCIModule(CIModuleInputDto dto){
        var ciModule = new CIModule();

        ciModule.setId(dto.getId());
        if(dto.getName()!=null){
            ciModule.setName(dto.getName());
        }
        ciModule.setType(dto.getType());
        ciModule.setPrice(dto.getPrice());

        return ciModule;
    }
    public static CIModuleDto fromCIModule(CIModule ciModule){
        CIModuleDto dto = new CIModuleDto();

        dto.setId(ciModule.getId());
        dto.setName(ciModule.getName());
        dto.setType(ciModule.getType());
        dto.setPrice(ciModule.getPrice());

        return dto;
    }
}
