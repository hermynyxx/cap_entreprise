package fr.hermancia.capentreprise.service;

import fr.hermancia.capentreprise.entity.BusinessModel;
import fr.hermancia.capentreprise.repository.BusinessModelRepository;
import fr.hermancia.capentreprise.service.interfaces.DAOEntityInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BusinessModelService
        implements
        DAOEntityInterface<BusinessModel>{

    private BusinessModelRepository businessModelRepository;

    @Override
    public List<BusinessModel> findAll() {
        return businessModelRepository.findAll();
    }

    @Override
    public BusinessModel findById(Long id) {
        return businessModelRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

}
