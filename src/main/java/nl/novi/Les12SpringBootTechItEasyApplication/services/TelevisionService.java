package nl.novi.Les12SpringBootTechItEasyApplication.services;
import nl.novi.Les12SpringBootTechItEasyApplication.dtos.TelevisionDto;
import nl.novi.Les12SpringBootTechItEasyApplication.dtos.TelevisionInputDto;
import nl.novi.Les12SpringBootTechItEasyApplication.exceptions.RecordNotFoundException;
import nl.novi.Les12SpringBootTechItEasyApplication.models.Television;
import nl.novi.Les12SpringBootTechItEasyApplication.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TelevisionService {
    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<Television> getTelevisions(){
        return televisionRepository.findAll();
    }

    //DONE
    public TelevisionDto getTelevisionById(Long id) {
        if(televisionRepository.findById(id).isPresent()){
            Television tv = televisionRepository.findById(id).get();
            return fromTelevision(tv);
        } else {
            throw new RecordNotFoundException("The entered value isn't correct or doesn't exist. Search again with another value.");
        }
    }

    //DONE
    public TelevisionDto saveTelevision(TelevisionInputDto dto) {
        Television tv = toTelevision(dto);
        televisionRepository.save(tv);
        return fromTelevision(tv);
    }

//DONE
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

    public Television toTelevision(TelevisionInputDto dto){
        var television = new Television();

        television.setId(dto.getId());
        television.setType(dto.getType());
        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(dto.getScreenType());
        television.setScreenQuality(dto.getScreenQuality());
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

    public TelevisionDto fromTelevision(Television television){
        TelevisionDto dto = new TelevisionDto();

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
}
