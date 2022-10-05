package nl.novi.Les13SpringBootTechItEasyApplication.models;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class AuthorityKey implements Serializable {
    private String username;
    private String authority;
}
