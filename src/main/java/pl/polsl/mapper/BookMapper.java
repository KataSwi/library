package pl.polsl.mapper;

import pl.polsl.dto.*;
import pl.polsl.model.*;

import java.util.List;

/**
 * Created by Katarzyna on 08.12.2016.
 */
public interface BookMapper {
    AuthorEntity toAuthorEntity(AuthorDTO authorDTO);
    List<AuthorEntity> toAuthorEntityList(List<AuthorDTO> authorDTOList);
    AuthorDTO toAuthorDTO(AuthorEntity authorEntity);
    List<AuthorDTO> toAuthorDTOList(List<AuthorEntity> authorEntityList);
    BookEntity toBookEntity(BookDTO bookDTO);
    List<BookEntity> toBookEntityList(List<BookDTO> bookDTOList);
    BookDTO toBookDTO (BookEntity bookEntity);
    List<BookDTO> toBookDTOList(List<BookEntity> bookEntityList);
    BookcopyEntity toBookCopyEntity(BookCopyDTO bookCopyDTO);
    List<BookcopyEntity> toBookCopyEntityList(List<BookCopyDTO> bookCopyDTOList);
    BookCopyDTO toBookCopyDTO(BookcopyEntity bookcopyEntity);
    List<BookCopyDTO> toBookCopyDTOList(List<BookcopyEntity> bookcopyEntityList);
    GenreEntity toGenreEntity(GenreDTO genreDTO);
    List<GenreEntity> toGenreEntityList(List<GenreDTO> genreDTOList);
    GenreDTO toGenreDTO(GenreEntity genreEntity);
    List<GenreDTO> toGenreDTOList(List<GenreEntity> genreEntityList);
    BookstateEntity toBookStateEntity(BookStateDTO bookStateDTO);
    List<BookstateEntity> toBookStateEntityList(List<BookStateDTO> bookStateDTOList);
    BookStateDTO toBookStateDTO(BookstateEntity bookstateEntity);

}
