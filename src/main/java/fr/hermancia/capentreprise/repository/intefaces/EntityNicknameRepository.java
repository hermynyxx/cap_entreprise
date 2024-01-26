package fr.hermancia.capentreprise.repository.intefaces;

import java.util.Optional;

public interface EntityNicknameRepository<T>{

    Optional<T> findByNickname(String nickname);
}
