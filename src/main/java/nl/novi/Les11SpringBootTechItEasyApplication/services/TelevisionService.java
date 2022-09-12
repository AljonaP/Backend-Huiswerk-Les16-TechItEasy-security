package nl.novi.Les11SpringBootTechItEasyApplication.services;
import nl.novi.Les11SpringBootTechItEasyApplication.exceptions.RecordNotFoundException;
import nl.novi.Les11SpringBootTechItEasyApplication.models.Television;
import nl.novi.Les11SpringBootTechItEasyApplication.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;
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

    public Television getTelevisionById(Long id) {
        if(televisionRepository.findById(id).isPresent()){
            return televisionRepository.findById(id).get();
        } else {
            throw new RecordNotFoundException("The entered value isn't correct or doesn't exist. Search again with another value.");
        }
    }

    public Television saveTelevision(Television newTv) {
        return televisionRepository.save(newTv);
    }

    public Television updateTelevision(Television updatedTv, Long id) {
        Television tv = getTelevisionById(id);

        if(!tv.getId().equals(updatedTv.getId())) {
            tv.setId(updatedTv.getId());
        }

        if (!tv.getType().equals(updatedTv.getType())) {
            tv.setType(updatedTv.getType());
        }

        if (!tv.getBrand().equals(updatedTv.getBrand())) {
            tv.setBrand(updatedTv.getBrand());
        }

        if (!tv.getName().equals(updatedTv.getName())) {
            tv.setName(updatedTv.getName());
        }

        if (!tv.getPrice().equals(updatedTv.getPrice())) {
            tv.setPrice(updatedTv.getPrice());
        }

        if (!tv.getAvailableSize().equals(updatedTv.getAvailableSize())) {
            tv.setAvailableSize(updatedTv.getAvailableSize());
        }

        if(!tv.getRefreshRate().equals(updatedTv.getRefreshRate())) {
            tv.setRefreshRate(updatedTv.getRefreshRate());
        }

        if(!tv.getScreenType().equals(updatedTv.getScreenType())) {
            tv.setScreenType(updatedTv.getScreenType());
        }

        if(!tv.getScreenQuality().equals(updatedTv.getScreenQuality())) {
            tv.setScreenQuality(updatedTv.getScreenQuality());
        }

        if(!tv.getSmartTv().equals(updatedTv.getSmartTv())) {
            tv.setSmartTv(updatedTv.getSmartTv());
        }

        if(!tv.getWifi().equals(updatedTv.getWifi())) {
            tv.setWifi(updatedTv.getWifi());
        }

        if(!tv.getVoiceControl().equals(updatedTv.getVoiceControl())) {
            tv.setVoiceControl(updatedTv.getVoiceControl());
        }

        if(!tv.getHdr().equals(updatedTv.getHdr())) {
            tv.setHdr(updatedTv.getHdr());
        }

        if(!tv.getBluetooth().equals(updatedTv.getBluetooth())) {
            tv.setBluetooth(updatedTv.getBluetooth());
        }

        if(!tv.getAmbiLight().equals(updatedTv.getAmbiLight())) {
            tv.setAmbiLight(updatedTv.getAmbiLight());
        }

        if(!tv.getOriginalStock().equals(updatedTv.getOriginalStock())) {
            tv.setOriginalStock(updatedTv.getOriginalStock());
        }

        if(!tv.getSold().equals(updatedTv.getSold())) {
            tv.setSold(updatedTv.getSold());
        }

        return televisionRepository.save(updatedTv);
    }

    public void deleteTelevision(Long id){
        televisionRepository.deleteById(id);
    }
}
