package pl.polsl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.model.UsersEntity;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Repository
public interface UserRepository extends CrudRepository<UsersEntity,String> {
}
