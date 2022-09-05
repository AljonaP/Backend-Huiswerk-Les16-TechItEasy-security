package nl.novi.Les11SpringBootTechItEasyApplication.repositories;

import nl.novi.Les11SpringBootTechItEasyApplication.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TelevisionRepository extends JpaRepository<Television, Long> {
//    void deleteAllBy(Long id);
    void deleteAllById(Long id);
//    void getTelevisionsByBrand(String brand);
}
