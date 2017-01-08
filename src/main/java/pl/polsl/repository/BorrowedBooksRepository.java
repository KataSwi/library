package pl.polsl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.model.BorrowedbooksEntity;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Katarzyna on 22.11.2016.
 */
@Repository
@RepositoryRestResource
@Transactional
public interface BorrowedBooksRepository extends CrudRepository<BorrowedbooksEntity,Integer> {
    List<BorrowedbooksEntity> findAll();
    List<BorrowedbooksEntity> findByReaderCard(long readerCard);
    BorrowedbooksEntity findByReaderCardAndBookInventory(long readerCard, long bookInventory);
    List<BorrowedbooksEntity> findByBorrowingStateAndReturnDateBefore(int state, Timestamp timestamp);
    BorrowedbooksEntity findByBookInventoryAndBorrowingState(long inventory, int state);
    BorrowedbooksEntity findByReaderCardAndBookInventoryAndBorrowingState(long readerCard, long inventory, int state);
    List<BorrowedbooksEntity> findByReaderdCardAndBorrowingStateAndReturnDateBefore(long readerCard, int state, Timestamp timestamp);
}
