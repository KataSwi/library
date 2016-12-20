package pl.polsl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.model.AuthorEntity;

import java.util.List;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Repository
@RepositoryRestResource
@Transactional
public interface AuthorRepository extends CrudRepository<AuthorEntity,Integer> {
    List<AuthorEntity> findByAuthorSurname(String surname);
    List<AuthorEntity> findAll();
    AuthorEntity findByAuthorNameAndAuthorSurname(String name, String surname);
}
