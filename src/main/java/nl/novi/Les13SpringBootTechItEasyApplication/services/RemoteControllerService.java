package nl.novi.Les13SpringBootTechItEasyApplication.services;

import nl.novi.Les13SpringBootTechItEasyApplication.dtos.RemoteControllerDto;
import nl.novi.Les13SpringBootTechItEasyApplication.dtos.RemoteControllerInputDto;
import nl.novi.Les13SpringBootTechItEasyApplication.exceptions.RecordNotFoundException;
import nl.novi.Les13SpringBootTechItEasyApplication.models.RemoteController;
import nl.novi.Les13SpringBootTechItEasyApplication.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RemoteControllerService {
    private final RemoteControllerRepository remoteControllerRepository;

    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository) {
        this.remoteControllerRepository = remoteControllerRepository;
    }

    public List<RemoteController> getRemoteControllers(){
        return remoteControllerRepository.findAll();
    }

    public RemoteControllerDto getRemoteControllerById(Long id){
        if(remoteControllerRepository.findById(id).isPresent()){
            RemoteController remoteController = remoteControllerRepository.findById(id).get();
            return fromRemoteController(remoteController);
        } else {
            throw new RecordNotFoundException("The entered value isn't correct or doesn't exist. Search again with another value.");
        }
    }

    public RemoteControllerDto saveRemoteController(RemoteControllerInputDto dto) {
        RemoteController remoteController = toRemoteController(dto);
        remoteControllerRepository.save(remoteController);
        return fromRemoteController(remoteController);
    }

    public RemoteControllerDto updateRemoteController(RemoteControllerInputDto inputRemoteControllerDto, Long id) {
        RemoteController remoteController = remoteControllerRepository.findById(id).orElseThrow(() -> {throw new RecordNotFoundException("Remote Controller with this id doesn't exist. Try another Id.");});

        if(!remoteController.getId().equals(inputRemoteControllerDto.getId())) {
            remoteController.setId(inputRemoteControllerDto.getId());
        }
        if(!remoteController.getCompatibleWith().equals(inputRemoteControllerDto.getCompatibleWith())){
            remoteController.setCompatibleWith(inputRemoteControllerDto.getCompatibleWith());
        }

        if (!remoteController.getBatteryType().equals(inputRemoteControllerDto.getBatteryType())) {
            remoteController.setBatteryType(inputRemoteControllerDto.getBatteryType());
        }

        if (!remoteController.getName().equals(inputRemoteControllerDto.getName())) {
            remoteController.setName(inputRemoteControllerDto.getName());
        }

        if (!remoteController.getBrand().equals(inputRemoteControllerDto.getBrand())) {
            remoteController.setBrand(inputRemoteControllerDto.getBrand());
        }

        if (!remoteController.getPrice().equals(inputRemoteControllerDto.getPrice())) {
            remoteController.setPrice(inputRemoteControllerDto.getPrice());
        }

        if(!remoteController.getOriginalStock().equals(inputRemoteControllerDto.getOriginalStock())) {
            remoteController.setOriginalStock(inputRemoteControllerDto.getOriginalStock());
        }

        remoteControllerRepository.save(remoteController);

        return fromRemoteController(remoteController);
    }

    public void deleteRemoteController(@RequestBody Long id){
        remoteControllerRepository.deleteById(id);
    }

    public static RemoteController toRemoteController(RemoteControllerInputDto dto){
        var remoteController = new RemoteController();

        remoteController.setId(dto.getId());

        if(dto.getCompatibleWith()!=null){
            remoteController.setCompatibleWith(dto.getCompatibleWith());
        }
        if(dto.getBatteryType()!=null){
            remoteController.setBatteryType(dto.getBatteryType());
        }
        if(dto.getName()!=null){
            remoteController.setName(dto.getName());
        }

        if(dto.getBrand()!=null){
            remoteController.setBrand(dto.getBrand());
        }
        remoteController.setPrice(dto.getPrice());
        remoteController.setOriginalStock(dto.getOriginalStock());

        return remoteController;
    }

    public  static RemoteControllerDto fromRemoteController(RemoteController remoteController) {
        RemoteControllerDto dto = new RemoteControllerDto();

        dto.setId(remoteController.getId());
        dto.setCompatibleWith(remoteController.getCompatibleWith());
        dto.setBatteryType(remoteController.getBatteryType());
        dto.setName(remoteController.getName());
        dto.setBrand(remoteController.getBrand());
        dto.setPrice(remoteController.getPrice());
        dto.setOriginalStock(remoteController.getOriginalStock());

        return dto;
    }
}
