package nl.novi.Les13SpringBootTechItEasyApplication.services;

import nl.novi.Les13SpringBootTechItEasyApplication.dtos.UserDto;
import nl.novi.Les13SpringBootTechItEasyApplication.models.Authority;

import java.util.ArrayList;
import java.util.Set;


/*annotatie*/
public class CustomUserDetailsService implements UserDetailsService {

    /*autorwire userservice */

    private UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDto userDto = userService.getUser(username);


        String password = userDto.getPassword();

        Set<Authority> authorities = userDto.getAuthorities();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority: authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }

        return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities);
    }

}
