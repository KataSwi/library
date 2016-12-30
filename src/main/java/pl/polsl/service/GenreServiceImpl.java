package pl.polsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.dto.GenreDTO;
import pl.polsl.mapper.LibraryMapper;
import pl.polsl.model.GenreEntity;
import pl.polsl.repository.GenreRepository;

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
}
