package fr.hermancia.capentreprise.service;

import fr.hermancia.capentreprise.entity.Classification;
import fr.hermancia.capentreprise.repository.ClassificationRepository;
import fr.hermancia.capentreprise.service.interfaces.DAOEntityInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ClassificationService
        implements
        DAOEntityInterface<Classification> {

    private ClassificationRepository classificationRepository;


    @Override
    public List<Classification> findAll() {
        return classificationRepository.findAll();
    }

    @Override
    public Classification findById(Long id) {
        return classificationRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
