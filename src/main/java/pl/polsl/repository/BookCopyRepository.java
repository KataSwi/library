package pl.polsl.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.model.BookcopyEntity;

import java.util.List;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Repository
@RepositoryRestResource
@Transactional
public interface BookCopyRepository extends CrudRepository<BookcopyEntity,Long> {
    List<BookcopyEntity> findAll();
    List<BookcopyEntity> findByIsbn(String isbn);
    BookcopyEntity findByInventory(Long id);
    List<BookcopyEntity> findByStateAndIsbn(int state, String isbn);
    List<BookcopyEntity> findByStateAndInventory(int state, Long id);
}
