package fr.hermancia.capentreprise.service;

import fr.hermancia.capentreprise.entity.Genre;
import fr.hermancia.capentreprise.repository.GenreRepository;
import fr.hermancia.capentreprise.service.interfaces.DAOEntityInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GenreService
        implements
        DAOEntityInterface<Genre> {

    private GenreRepository genreRepository;
    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre findById(Long id) {
        return genreRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
