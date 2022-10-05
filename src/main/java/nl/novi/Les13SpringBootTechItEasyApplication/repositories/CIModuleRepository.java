package nl.novi.Les13SpringBootTechItEasyApplication.repositories;

import nl.novi.Les13SpringBootTechItEasyApplication.models.CIModule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CIModuleRepository extends JpaRepository<CIModule, Long> {
}
