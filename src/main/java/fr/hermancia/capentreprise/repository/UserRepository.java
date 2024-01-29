package fr.hermancia.capentreprise.repository;

import fr.hermancia.capentreprise.entity.User;
import fr.hermancia.capentreprise.repository.intefaces.EntityFindByEmailRepository;
import fr.hermancia.capentreprise.repository.intefaces.EntityFindByNicknameRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository
        extends
        JpaRepository<User, Long>,
        EntityFindByEmailRepository<User>,
        EntityFindByNicknameRepository<User>{


}
