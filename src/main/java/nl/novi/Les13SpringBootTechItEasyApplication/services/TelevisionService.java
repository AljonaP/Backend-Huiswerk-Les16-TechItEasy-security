package nl.novi.Les13SpringBootTechItEasyApplication.services;
import nl.novi.Les13SpringBootTechItEasyApplication.dtos.*;
import nl.novi.Les13SpringBootTechItEasyApplication.exceptions.RecordNotFoundException;
import nl.novi.Les13SpringBootTechItEasyApplication.models.CIModule;
import nl.novi.Les13SpringBootTechItEasyApplication.models.RemoteController;
import nl.novi.Les13SpringBootTechItEasyApplication.models.Television;
import nl.novi.Les13SpringBootTechItEasyApplication.models.WallBracket;
import nl.novi.Les13SpringBootTechItEasyApplication.repositories.CIModuleRepository;
import nl.novi.Les13SpringBootTechItEasyApplication.repositories.RemoteControllerRepository;
import nl.novi.Les13SpringBootTechItEasyApplication.repositories.TelevisionRepository;

import nl.novi.Les13SpringBootTechItEasyApplication.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {
    private final TelevisionRepository televisionRepository;
    private final RemoteControllerRepository remoteControllerRepository;
    private final RemoteControllerService remoteControllerService;

    private final CIModuleRepository ciModuleRepository;
    private final CIModuleService ciModuleService;

    private final WallBracketRepository wallBracketRepository;
    private final WallBracketService wallBracketService;


    public TelevisionService(TelevisionRepository televisionRepository, RemoteControllerRepository remoteControllerRepository, RemoteControllerService remoteControllerService, CIModuleRepository ciModuleRepository, CIModuleService ciModuleService, WallBracketRepository wallBracketRepository, WallBracketService wallBracketService) {
        this.televisionRepository = televisionRepository;
        this.remoteControllerRepository = remoteControllerRepository;
        this.remoteControllerService = remoteControllerService;
        this.ciModuleRepository = ciModuleRepository;
        this.ciModuleService = ciModuleService;
        this.wallBracketRepository = wallBracketRepository;
        this.wallBracketService = wallBracketService;
    }


    public List<TelevisionDto> getTelevisions() {
        List<Television> televisions = televisionRepository.findAll();
        List<TelevisionDto> dtos = new ArrayList<>();
        for (Television tv : televisions) {
            dtos.add(fromTelevision(tv));
        }
        return dtos;
    }


    public TelevisionDto getTelevisionById(Long id) {
        if(televisionRepository.findById(id).isPresent()){
            Television tv = televisionRepository.findById(id).get();
            return fromTelevision(tv);
        } else {
            throw new RecordNotFoundException("The entered value isn't correct or doesn't exist. Search again with another value.");
        }
    }
    public TelevisionDto saveTelevision(TelevisionInputDto dto) {
        Television tv = toTelevision(dto);
        televisionRepository.save(tv);
        return fromTelevision(tv);
    }

    public TelevisionDto updateTelevision(TelevisionInputDto inputDto, Long id) {
        Television tv = televisionRepository.findById(id).orElseThrow(() -> {throw new RecordNotFoundException("Tv with this id doesn't exist. Try another Id.");});

        if(!tv.getId().equals(inputDto.getId())) {
            tv.setId(inputDto.getId());
        }

        if (!tv.getType().equals(inputDto.getType())) {
            tv.setType(inputDto.getType());
        }

        if (!tv.getBrand().equals(inputDto.getBrand())) {
            tv.setBrand(inputDto.getBrand());
        }

        if (!tv.getName().equals(inputDto.getName())) {
            tv.setName(inputDto.getName());
        }

        if (!tv.getPrice().equals(inputDto.getPrice())) {
            tv.setPrice(inputDto.getPrice());
        }

        if (!tv.getAvailableSize().equals(inputDto.getAvailableSize())) {
            tv.setAvailableSize(inputDto.getAvailableSize());
        }

        if(!tv.getRefreshRate().equals(inputDto.getRefreshRate())) {
            tv.setRefreshRate(inputDto.getRefreshRate());
        }

        if(!tv.getScreenType().equals(inputDto.getScreenType())) {
            tv.setScreenType(inputDto.getScreenType());
        }

        if(!tv.getScreenQuality().equals(inputDto.getScreenQuality())) {
            tv.setScreenQuality(inputDto.getScreenQuality());
        }

        if(!tv.getSmartTv().equals(inputDto.getSmartTv())) {
            tv.setSmartTv(inputDto.getSmartTv());
        }

        if(!tv.getWifi().equals(inputDto.getWifi())) {
            tv.setWifi(inputDto.getWifi());
        }

        if(!tv.getVoiceControl().equals(inputDto.getVoiceControl())) {
            tv.setVoiceControl(inputDto.getVoiceControl());
        }

        if(!tv.getHdr().equals(inputDto.getHdr())) {
            tv.setHdr(inputDto.getHdr());
        }

        if(!tv.getBluetooth().equals(inputDto.getBluetooth())) {
            tv.setBluetooth(inputDto.getBluetooth());
        }

        if(!tv.getAmbiLight().equals(inputDto.getAmbiLight())) {
            tv.setAmbiLight(inputDto.getAmbiLight());
        }

        if(!tv.getOriginalStock().equals(inputDto.getOriginalStock())) {
            tv.setOriginalStock(inputDto.getOriginalStock());
        }

        if(!tv.getSold().equals(inputDto.getSold())) {
            tv.setSold(inputDto.getSold());
        }

        televisionRepository.save(tv);

        return fromTelevision(tv);
    }

    public void deleteTelevision(@RequestBody Long id){
        televisionRepository.deleteById(id);
    }

    public static Television toTelevision(TelevisionInputDto dto){
        var television = new Television();

        television.setId(dto.getId());
        if(dto.getType()!=null){
            television.setType(dto.getType());
        }
        if(dto.getType()!=null) {
            television.setBrand(dto.getBrand());
        }
        if(dto.getType()!=null) {
            television.setName(dto.getName());
        }
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        if(dto.getType()!=null) {
            television.setScreenType(dto.getScreenType());
        }
        if(dto.getType()!=null) {
            television.setScreenQuality(dto.getScreenQuality());
        }
        television.setSmartTv(dto.getSmartTv());
        television.setWifi(dto.getWifi());
        television.setVoiceControl(dto.getVoiceControl());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbiLight(dto.getAmbiLight());
        television.setOriginalStock(dto.getOriginalStock());
        television.setSold(dto.getSold());

        return television;
    }

    public static TelevisionDto fromTelevision(Television television){
        TelevisionDto dto = new TelevisionDto();
        if(!(television.getRemotecontroller() == null)){
            RemoteController remoteController = television.getRemotecontroller();
            RemoteControllerDto remoteControllerDto = RemoteControllerService.fromRemoteController(remoteController);
            dto.setRemoteControllerDto(remoteControllerDto);
//            dto.setRemoteControllerDto(remoteControllerService.fromRemoteController(television.getRemotecontroller()));
        }

        if(!(television.getCimodule() == null)){
            CIModule ciModule = television.getCimodule();
            CIModuleDto ciModuleDto = CIModuleService.fromCIModule(ciModule);
            dto.setCiModuleDto(ciModuleDto);
        }

        if(!(television.getWallBrackets() == null)){
            List<WallBracket> wallBrackets = television.getWallBrackets();
            List<WallBracketDto> wallBracketsDtos = new ArrayList<>();
            for (WallBracket wallBracket : wallBrackets) {
                WallBracketDto wallBracketDto = WallBracketService.fromWallBracket(wallBracket);
                wallBracketsDtos.add(wallBracketDto);
            }
            dto.setWallBracketDtos(wallBracketsDtos);
        }
        dto.setId(television.getId());
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getSmartTv());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());

        return dto;
    }

    public TelevisionDto assignRemoteControllerToTelevision(Long remotecontrollerId, Long televisionId){
        Optional<Television> optionalTelevision = televisionRepository.findById(televisionId);
        Optional<RemoteController> optionalRemoteController = remoteControllerRepository.findById(remotecontrollerId);
        if(optionalRemoteController.isPresent() && optionalTelevision.isPresent()){
            Television television = optionalTelevision.get();
            RemoteController remoteController = optionalRemoteController.get();
            television.setRemotecontroller(remoteController);
            televisionRepository.save(television);
            return fromTelevision(television); //hier krijgen we een DTO

        } else {
            throw new RuntimeException("The requested TV isn't found");
        }
    }

    public TelevisionDto assignCIModuleToTelevision(Long ciModuleId, Long televisionId){
        Optional<Television> optionalTelevision = televisionRepository.findById(televisionId);
        Optional<CIModule> optionalCIModule = ciModuleRepository.findById(ciModuleId);

        if(optionalTelevision.isPresent() && optionalCIModule.isPresent()){
            Television television = optionalTelevision.get();
            CIModule ciModule = optionalCIModule.get();

            television.setCimodule(ciModule);
            televisionRepository.save(television);

            return fromTelevision(television);

        } else {
            throw new RuntimeException("The requested TV isn't found");
        }
    }
    public TelevisionDto assignWallBracketsToTelevision(Long wallBracketId, Long televisionId){
        Optional<Television> optionalTelevision = televisionRepository.findById(televisionId);
        Optional<WallBracket> optionalWallBracket = wallBracketRepository.findById(wallBracketId);

        if(optionalTelevision.isPresent() && optionalWallBracket.isPresent()){
            Television television = optionalTelevision.get();
            WallBracket wallBracket = optionalWallBracket.get();

            television.addWallBracket(wallBracket);
            televisionRepository.save(television);

            return fromTelevision(television);

        } else {
            throw new RuntimeException("The requested TV or the wall bracket isn't found");
        }
    }
}
