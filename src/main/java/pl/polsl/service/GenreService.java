package pl.polsl.service;

import pl.polsl.dto.GenreDTO;

import java.util.List;

/**
 * Created by Katarzyna on 08.12.2016.
 */
public interface GenreService {
    GenreDTO createGenre(GenreDTO genreDTO);
    List<GenreDTO> findAllGenres();
    GenreDTO findOneGenre(int id);
    GenreDTO findGenreType(String type);
}
