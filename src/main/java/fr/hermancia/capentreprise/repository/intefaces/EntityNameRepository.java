package fr.hermancia.capentreprise.repository.intefaces;

import java.util.Optional;

public interface EntityNameRepository<T> {

    Optional<T> findByName(String name);
}
