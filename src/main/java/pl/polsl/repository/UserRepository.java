package pl.polsl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.polsl.model.UsersEntity;

import java.util.List;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Repository
@RepositoryRestResource
public interface UserRepository extends CrudRepository<UsersEntity,String> {
    public UsersEntity findByUserName(String userName);
    public List<UsersEntity> findBySurname(String surname);

}
