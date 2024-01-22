package fr.hermancia.capentreprise.repository;

import fr.hermancia.capentreprise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends
        JpaRepository<User, Long>{
}
