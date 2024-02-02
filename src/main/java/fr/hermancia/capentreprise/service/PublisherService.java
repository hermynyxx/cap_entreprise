package fr.hermancia.capentreprise.service;

import fr.hermancia.capentreprise.entity.BusinessModel;
import fr.hermancia.capentreprise.entity.Publisher;
import fr.hermancia.capentreprise.repository.PublisherRepository;
import fr.hermancia.capentreprise.service.interfaces.DAOEntityInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class PublisherService
            implements
            DAOEntityInterface<Publisher> {


    private PublisherRepository publisherRepository;
    @Override
    public List<Publisher>findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher findById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<Publisher> findAllSorted() {
        return publisherRepository.findAllByOrderByNameAsc();
    }
}
