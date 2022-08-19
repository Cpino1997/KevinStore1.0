package cl.pinolabs.kevinstore.model.domain.service;

import cl.pinolabs.kevinstore.model.domain.dto.Rol;
import cl.pinolabs.kevinstore.model.domain.dto.User;
import cl.pinolabs.kevinstore.model.domain.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //return new User("brian", "{noop}kupita", new ArrayList<>());
        User user = repo.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                mapperRols(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapperRols(List<Rol> roles){
        return roles.stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRolName()))
                .collect(Collectors.toList());
    }

    public User save(User user){
        return repo.save(user);
    }

}