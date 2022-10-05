package nl.novi.Les13SpringBootTechItEasyApplication.repositories;

import nl.novi.Les13SpringBootTechItEasyApplication.models.RemoteController;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RemoteControllerRepository extends JpaRepository<RemoteController, Long> {
    List<RemoteController> getAllRemoteControllersByBrand(String brand);
}
