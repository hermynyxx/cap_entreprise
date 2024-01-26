package fr.hermancia.capentreprise.service.interfaces;

import java.util.List;

public interface DAOEntityInterface<T>
    extends
        DAOFindByIdServiceInterface<T>{

    List<T> findAll();
}
