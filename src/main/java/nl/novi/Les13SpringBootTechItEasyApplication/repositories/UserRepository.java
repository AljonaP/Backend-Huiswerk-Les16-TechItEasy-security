package nl.novi.Les13SpringBootTechItEasyApplication.repositories;

import nl.novi.Les13SpringBootTechItEasyApplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
