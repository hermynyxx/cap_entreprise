package fr.hermancia.capentreprise.service;

import fr.hermancia.capentreprise.entity.Platform;
import fr.hermancia.capentreprise.repository.PlatformRepository;
import fr.hermancia.capentreprise.service.interfaces.DAOEntityInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PlatformService implements
        DAOEntityInterface<Platform> {


    private PlatformRepository platformRepository;
    @Override
    public List<Platform> findAll() {
        return platformRepository.findAll();
    }

    @Override
    public Platform findById(Long id) {
        return platformRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
