package nl.novi.Les13SpringBootTechItEasyApplication.repositories;

import nl.novi.Les13SpringBootTechItEasyApplication.models.WallBracket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WallBracketRepository extends JpaRepository<WallBracket, Long> {
}
