package fr.hermancia.capentreprise.repository;

import fr.hermancia.capentreprise.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository  extends
        JpaRepository<Platform, Long> {
}
