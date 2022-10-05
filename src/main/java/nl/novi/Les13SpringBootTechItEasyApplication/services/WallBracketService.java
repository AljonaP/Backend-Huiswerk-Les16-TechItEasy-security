package nl.novi.Les13SpringBootTechItEasyApplication.services;

import nl.novi.Les13SpringBootTechItEasyApplication.dtos.TelevisionDto;
import nl.novi.Les13SpringBootTechItEasyApplication.dtos.WallBracketDto;
import nl.novi.Les13SpringBootTechItEasyApplication.dtos.WallBracketInputDto;
import nl.novi.Les13SpringBootTechItEasyApplication.exceptions.RecordNotFoundException;
import nl.novi.Les13SpringBootTechItEasyApplication.models.Television;
import nl.novi.Les13SpringBootTechItEasyApplication.models.WallBracket;
import nl.novi.Les13SpringBootTechItEasyApplication.repositories.TelevisionRepository;
import nl.novi.Les13SpringBootTechItEasyApplication.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class WallBracketService {

    private final WallBracketRepository wallBracketRepository;
    private final TelevisionRepository televisionRepository;



    public WallBracketService(WallBracketRepository wallBracketRepository, TelevisionRepository televisionRepository) {
        this.wallBracketRepository = wallBracketRepository;
        this.televisionRepository = televisionRepository;
    }




//    public List<WallBracket> getWallBrackets(){
//        return wallBracketRepository.findAll();
//    }

    public List<WallBracketDto> getWallBrackets(){
        List<WallBracket> wallBrackets = wallBracketRepository.findAll();
        List<WallBracketDto> dtos = new ArrayList<>();
        for (WallBracket wallBracket : wallBrackets) {
            dtos.add(fromWallBracket(wallBracket));
        }
        return dtos;
    }

    public WallBracketDto getWallBracketById(Long id) {
        if(wallBracketRepository.findById(id).isPresent()){
            WallBracket wallBracket = wallBracketRepository.findById(id).get();
            return fromWallBracket(wallBracket);
        } else {
            throw new RecordNotFoundException("The entered value isn't correct or doesn't exist. Search again with another value.");
        }
    }
    public WallBracketDto saveWallBracket(WallBracketInputDto dto) {
        WallBracket wallBracket = toWallBracket(dto);
        wallBracketRepository.save(wallBracket);
        return fromWallBracket(wallBracket);
    }

    public WallBracketDto updateWallBracket(WallBracketInputDto inputDto, Long id) {
        WallBracket wallBracket = wallBracketRepository.findById(id).orElseThrow(() -> {throw new RecordNotFoundException("Wall Bracket with this id doesn't exist. Try another Id.");});

        if(!wallBracket.getId().equals(inputDto.getId())) {
            wallBracket.setId(inputDto.getId());
        }

        if (!wallBracket.getSize().equals(inputDto.getSize())) {
            wallBracket.setSize(inputDto.getSize());
        }

        if (!wallBracket.getAdjustable().equals(inputDto.getAdjustable())) {
            wallBracket.setAdjustable(inputDto.getAdjustable());
        }

        if (!wallBracket.getName().equals(inputDto.getName())) {
            wallBracket.setName(inputDto.getName());
        }

        if (!wallBracket.getPrice().equals(inputDto.getPrice())) {
            wallBracket.setPrice(inputDto.getPrice());
        }

        wallBracketRepository.save(wallBracket);

        return fromWallBracket(wallBracket);
    }

    public void deleteWallBracket(@RequestBody Long id){
        wallBracketRepository.deleteById(id);
    }

    public static WallBracket toWallBracket(WallBracketInputDto dto){
        var wallBracket = new WallBracket();

        wallBracket.setId(dto.getId());
        if(dto.getSize()!=null){
            wallBracket.setSize(wallBracket.getSize());
        }

        wallBracket.setAdjustable(wallBracket.getAdjustable());
        wallBracket.setName(wallBracket.getName());
        wallBracket.setPrice(wallBracket.getPrice());

        return wallBracket;
    }
    public static WallBracketDto fromWallBracket(WallBracket wallBracket){
        WallBracketDto dto = new WallBracketDto();

//        if(!(wallBracket.getTelevisions() == null)){
//            List<Television> televisions = wallBracket.getTelevisions();
//            List<TelevisionDto> televisionDtos = new ArrayList<>();
//            for (Television television : televisions) {
//                TelevisionDto televisionDto = TelevisionService.fromTelevision(television);
//                televisionDtos.add(televisionDto);
//            }
//            dto.setTelevisionDtos(televisionDtos);
//        }
        dto.setId(wallBracket.getId());
        dto.setSize(wallBracket.getSize());
        dto.setAdjustable(wallBracket.getAdjustable());
        dto.setName(wallBracket.getName());
        dto.setPrice(wallBracket.getPrice());

        return dto;
    }
}


