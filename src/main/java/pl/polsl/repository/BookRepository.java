package pl.polsl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.model.BookEntity;

import java.util.List;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Repository
@RepositoryRestResource
@Transactional
public interface BookRepository extends CrudRepository<BookEntity,String> {
    List<BookEntity> findByTitle(String title);
    BookEntity findByIsbn(String isbn);
    List<BookEntity> findAll();
}
