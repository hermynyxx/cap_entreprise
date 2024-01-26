package fr.hermancia.capentreprise.repository.intefaces;

import java.util.Optional;

public interface EntityFindByNicknameRepository <T>{

    Optional<T> findByNickname(String nickname);
}
