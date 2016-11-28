package pl.polsl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.polsl.model.BookcopyEntity;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Repository
@RepositoryRestResource
public interface BookCopyRepository extends CrudRepository<BookcopyEntity,Long> {
}
