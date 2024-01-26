package fr.hermancia.capentreprise.repository.intefaces;

import java.util.Optional;

public interface EntityFindByEmailRepository<T> {
    Optional<T> findByEmail(String email);
}
