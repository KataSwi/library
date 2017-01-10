package pl.polsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.dto.GenreDTO;
import pl.polsl.mapper.LibraryMapper;
import pl.polsl.model.GenreEntity;
import pl.polsl.repository.GenreRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katarzyna on 08.12.2016.
 */
@Service
public class GenreServiceImpl implements GenreService{

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    public GenreDTO createGenre(GenreDTO genreDTO) {
        if(genreDTO == null){
            return null;
        }
        GenreEntity genreEntity = libraryMapper.toGenreEntity(genreDTO);
        genreEntity = genreRepository.save(genreEntity);
        return libraryMapper.toGenreDTO(genreEntity);
    }

    @Override
    public List<GenreDTO> findAllGenres() {
        List<GenreEntity> genreEntityList = genreRepository.findAll();
        List<GenreDTO> genreDTOList = libraryMapper.toGenreDTOList(genreEntityList);
        return genreDTOList;
    }

    @Override
    public GenreDTO findOneGenre(int id) {
        GenreEntity foundGenre = genreRepository.findOne(id);
        return libraryMapper.toGenreDTO(foundGenre);
    }

    @Override
    public GenreDTO findGenreType(String type) {
        GenreEntity foundGenre = genreRepository.findByType(type);
        return libraryMapper.toGenreDTO(foundGenre);
    }

    @Override
    public List<GenreDTO> findSimilarGenres(String type, String rate) {
        GenreEntity genreEntity = genreRepository.findByType(type);
        List<GenreDTO> result = new ArrayList<>();

        if(genreEntity == null){
            return null;
        }

        if(rate.equals("bpodobne")){
            result = searchSimilar(genreEntity.getType(),0.8, 1);

        }else if (rate.equals("podobne")){
            result = searchSimilar(genreEntity.getType(), 0.5, 0.7);

        }else if (rate.equals("tpodone")){
            result = searchSimilar(genreEntity.getType(), 0.2, 0.4);

        }else if (rate.equals("niepodobne")){
            result = searchSimilar(genreEntity.getType(), 0, 0.1);

        }

        return result;
    }

    private List<GenreDTO> searchSimilar(String type, double start, double end){
        List<GenreEntity> genreEntities;
        List<GenreDTO> genreDTOs = new ArrayList<>();

        if(type.equals("biografia")){
            genreEntities = genreRepository.findByBiografiaBetween(start,end);
            genreDTOs = libraryMapper.toGenreDTOList(genreEntities);
        } else if (type.equals("dzieci")){
            genreEntities = genreRepository.findByDzieciBetween(start,end);
            genreDTOs = libraryMapper.toGenreDTOList(genreEntities);
        } else if (type.equals("mlodziez")){
            genreEntities = genreRepository.findByMlodziezBetween(start,end);
            genreDTOs = libraryMapper.toGenreDTOList(genreEntities);
        } else if (type.equals("encyklopedia")){
            genreEntities = genreRepository.findByEncyklopediaBetween(start,end);
            genreDTOs = libraryMapper.toGenreDTOList(genreEntities);
        } else if (type.equals("fantastyka")){
            genreEntities = genreRepository.findByFantastykaBetween(start,end);
            genreDTOs = libraryMapper.toGenreDTOList(genreEntities);
        } else if (type.equals("filozofia")){
            genreEntities = genreRepository.findByFilozofiaBetween(start,end);
            genreDTOs = libraryMapper.toGenreDTOList(genreEntities);
        } else if (type.equals("historia")){
            genreEntities = genreRepository.findByHistoriaBetween(start,end);
            genreDTOs = libraryMapper.toGenreDTOList(genreEntities);
        } else if (type.equals("poezja")){
            genreEntities = genreRepository.findByPoezjaBetween(start,end);
            genreDTOs = libraryMapper.toGenreDTOList(genreEntities);
        } else if (type.equals("lpiekna")){
            genreEntities = genreRepository.findByLpieknaBetween(start,end);
            genreDTOs = libraryMapper.toGenreDTOList(genreEntities);
        } else if (type.equals("lfaktu")){
            genreEntities = genreRepository.findByLfaktuBetween(start,end);
            genreDTOs = libraryMapper.toGenreDTOList(genreEntities);
        } else if (type.equals("obyczajowa")){
            genreEntities = genreRepository.findByObyczajowaBetween(start,end);
            genreDTOs = libraryMapper.toGenreDTOList(genreEntities);
        } else if (type.equals("romans")){
            genreEntities = genreRepository.findByRomansBetween(start,end);
            genreDTOs = libraryMapper.toGenreDTOList(genreEntities);
        } else if (type.equals("sensacja")){
            genreEntities = genreRepository.findBySensacjaBetween(start,end);
            genreDTOs = libraryMapper.toGenreDTOList(genreEntities);
        } else if (type.equals("kryminal")){
            genreEntities = genreRepository.findByKryminalBetween(start,end);
            genreDTOs = libraryMapper.toGenreDTOList(genreEntities);
        } else if (type.equals("thriller")){
            genreEntities = genreRepository.findByThrillerBetween(start,end);
            genreDTOs = libraryMapper.toGenreDTOList(genreEntities);
        } else if (type.equals("horror")){
            genreEntities = genreRepository.findByHorrorBetween(start,end);
            genreDTOs = libraryMapper.toGenreDTOList(genreEntities);
        }

        return genreDTOs;
    }
}
