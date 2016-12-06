package pl.polsl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.model.GenreEntity;

import java.util.List;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Repository
@RepositoryRestResource
@Transactional
public interface GenreRepository extends CrudRepository<GenreEntity,Integer> {
    List<GenreEntity> findAll();
}
