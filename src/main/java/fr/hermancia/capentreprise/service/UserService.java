package fr.hermancia.capentreprise.service;

import fr.hermancia.capentreprise.DTO.RegistrationUserDTO;
import fr.hermancia.capentreprise.entity.Gamer;
import fr.hermancia.capentreprise.entity.Moderator;
import fr.hermancia.capentreprise.entity.User;
import fr.hermancia.capentreprise.repository.UserRepository;
import fr.hermancia.capentreprise.service.interfaces.DAOFindAllServiceInterface;
import fr.hermancia.capentreprise.service.interfaces.DAOFindByIdServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService
        implements
        DAOFindAllServiceInterface<User>,
        DAOFindByIdServiceInterface<User>,
        UserDetailsService {

    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByNickname(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getNickname(),
                user.getPassword(),
                userGrantedAuthority(user)
        );
    }

    private List<GrantedAuthority> userGrantedAuthority(User user) {
        if (user instanceof Moderator) {
            return List.of(new SimpleGrantedAuthority("ROLE_MODERATOR"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_GAMER"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void create(RegistrationUserDTO registrationDTO) {

        Optional<User> userOptional = this.userRepository.findByEmail(registrationDTO.getEmail());
        if(userOptional.isPresent()) {
            throw new RuntimeException("Veuillez renseigner un autre email");
        }
        Gamer user = new Gamer();
        user.setNickname(registrationDTO.getUsername());
        user.setEmail(registrationDTO.getEmail().toLowerCase());
        user.setBirthAt(registrationDTO.getBirthAt());
        String password = this.passwordEncoder.encode(registrationDTO.getPassword());
        user.setPassword(password);
        this.userRepository.saveAndFlush(user);

    }

    public User edit(String name, RegistrationUserDTO userPutDTO) {
        Optional<User> optionalUser = userRepository.findByNickname(name);
        optionalUser.orElseThrow(() -> new EntityNotFoundException("L'élément n'a pas été trouvé."));
        User user = optionalUser.get();
        return handleEdit(user, userPutDTO);
    }

    public User edit(Long id, RegistrationUserDTO userPutDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.orElseThrow(() -> new EntityNotFoundException("Lélément n'a pas été trouvé."));
        User user = optionalUser.get();
        return handleEdit(user, userPutDTO);
    }

    private User handleEdit(User user, RegistrationUserDTO userPutDTO) {
        if (!userPutDTO.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userPutDTO.getPassword()));
        }
        user.setImage(userPutDTO.getImage());
        user.setNickname(userPutDTO.getUsername());

        userRepository.flush();
        return user;
    }



    public User findByNickname(String nickname) {
        return userRepository.findByNickname(nickname).orElseThrow(EntityNotFoundException::new);
    }

    public RegistrationUserDTO getUserPutDTOByUser(User user) {
        RegistrationUserDTO userPutDTO = new RegistrationUserDTO();
        userPutDTO.setUsername(user.getNickname());

        return userPutDTO;
    }

}
