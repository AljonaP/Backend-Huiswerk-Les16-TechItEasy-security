package nl.novi.Les12SpringBootTechItEasyApplication.repositories;

import nl.novi.Les12SpringBootTechItEasyApplication.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TelevisionRepository extends JpaRepository<Television, Long> {
//    void deleteAllBy(Long id);
    void deleteAllById(Long id);
    List<Television> getAllTelevisionsByBrand(String brand);
}
