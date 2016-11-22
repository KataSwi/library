package pl.polsl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.model.ReaderEntity;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Repository
public interface ReaderRepository extends CrudRepository<ReaderEntity,Long> {
}
