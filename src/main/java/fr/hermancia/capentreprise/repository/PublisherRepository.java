package fr.hermancia.capentreprise.repository;

import fr.hermancia.capentreprise.entity.Publisher;
import fr.hermancia.capentreprise.repository.intefaces.EntityNameRepository;
import fr.hermancia.capentreprise.repository.intefaces.EntitySlugRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository
        extends
        JpaRepository<Publisher, Long>,
        EntityNameRepository<Publisher>,
        EntitySlugRepository<Publisher> {
    List<Publisher> findAllByOrderByNameAsc();
}
