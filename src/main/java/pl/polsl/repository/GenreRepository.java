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
    GenreEntity findByType(String type);
    List<GenreEntity> findByBiografiaBetween(double begin, double end);
    List<GenreEntity> findByDzieciBetween(double begin, double end);
    List<GenreEntity> findByMlodziezBetween(double begin, double end);
    List<GenreEntity> findByEncyklopediaBetween(double begin, double end);
    List<GenreEntity> findByFantastykaBetween(double begin, double end);
    List<GenreEntity> findByFilozofiaBetween(double begin, double end);
    List<GenreEntity> findByHistoriaBetween(double begin, double end);
    List<GenreEntity> findByPoezjaBetween(double begin, double end);
    List<GenreEntity> findByLpieknaBetween(double begin, double end);
    List<GenreEntity> findByLfaktuBetween(double begin, double end);
    List<GenreEntity> findByObyczajowaBetween(double begin, double end);
    List<GenreEntity> findByRomansBetween(double begin, double end);
    List<GenreEntity> findBySensacjaBetween(double begin, double end);
    List<GenreEntity> findByKryminalBetween(double begin, double end);
    List<GenreEntity> findByThrillerBetween(double begin, double end);
    List<GenreEntity> findByHorrorBetween(double begin, double end);
}
