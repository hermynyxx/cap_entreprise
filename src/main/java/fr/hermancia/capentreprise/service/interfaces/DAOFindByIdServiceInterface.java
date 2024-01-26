package fr.hermancia.capentreprise.service.interfaces;

public interface DAOFindByIdServiceInterface<T> {

    T findById(Long id);
}
