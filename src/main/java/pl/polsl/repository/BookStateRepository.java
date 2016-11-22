package pl.polsl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.model.BookstateEntity;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Repository
public interface BookStateRepository extends CrudRepository<BookstateEntity,Integer> {
}
