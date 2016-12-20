package pl.polsl.mapper;

import org.springframework.stereotype.Component;
import pl.polsl.dto.*;
import pl.polsl.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katarzyna on 08.12.2016.
 */
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public AuthorEntity toAuthorEntity(AuthorDTO authorDTO) {
        if(authorDTO == null){
            return null;
        }
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setAuthorid(authorDTO.getAuthorid());
        authorEntity.setAuthorName(authorDTO.getAuthorName());
        authorEntity.setAuthorSurname(authorDTO.getAuthorSurname());
        return authorEntity;
    }

    @Override
    public List<AuthorEntity> toAuthorEntityList(List<AuthorDTO> authorDTOList) {
        if(authorDTOList == null){
            return null;
        }
        List<AuthorEntity> result = new ArrayList<>();
        authorDTOList.forEach(authorDTO -> result.add(toAuthorEntity(authorDTO)));
        return result;
    }

    @Override
    public AuthorDTO toAuthorDTO(AuthorEntity authorEntity) {
        if(authorEntity == null){
            return null;
        }
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setAuthorid(authorEntity.getAuthorid());
        authorDTO.setAuthorName(authorEntity.getAuthorName());
        authorDTO.setAuthorSurname(authorEntity.getAuthorSurname());
        return authorDTO;
    }

    @Override
    public List<AuthorDTO> toAuthorDTOList(List<AuthorEntity> authorEntityList) {
        if(authorEntityList == null){
            return null;
        }
        List<AuthorDTO> result = new ArrayList<>();
        authorEntityList.forEach(authorEntity -> result.add(toAuthorDTO(authorEntity)));
        return result;
    }

    @Override
    public BookcopyEntity toBookCopyEntity(BookCopyDTO bookCopyDTO) {
        if(bookCopyDTO == null){
            return null;
        }
        BookcopyEntity bookcopyEntity = new BookcopyEntity();
        bookcopyEntity.setInventory(bookCopyDTO.getInventory());
        bookcopyEntity.setIsbn(bookCopyDTO.getIsbn());
        bookcopyEntity.setState(bookCopyDTO.getState());
        bookcopyEntity.setBookCopy(toBookEntity(bookCopyDTO.getBookDTO()));
        bookcopyEntity.setBookByState(toBookStateEntity(bookCopyDTO.getStateDTO()));
        return bookcopyEntity;
    }

    @Override
    public List<BookcopyEntity> toBookCopyEntityList(List<BookCopyDTO> bookCopyDTOList) {
        if(bookCopyDTOList == null){
            return null;
        }
        List<BookcopyEntity> result = new ArrayList<>();
        bookCopyDTOList.forEach(bookCopyDTO -> result.add(toBookCopyEntity(bookCopyDTO)));
        return result;
    }

    @Override
    public BookCopyDTO toBookCopyDTO(BookcopyEntity bookcopyEntity) {
        if(bookcopyEntity == null){
            return null;
        }
        BookCopyDTO bookCopyDTO = new BookCopyDTO();
        bookCopyDTO.setInventory(bookcopyEntity.getInventory());
        bookCopyDTO.setIsbn(bookcopyEntity.getIsbn());
        bookCopyDTO.setState(bookcopyEntity.getState());
        bookCopyDTO.setBookDTO(toBookDTO(bookcopyEntity.getBookCopy()));
        bookCopyDTO.setStateDTO(toBookStateDTO(bookcopyEntity.getBookByState()));
        return bookCopyDTO;
    }

    @Override
    public List<BookCopyDTO> toBookCopyDTOList(List<BookcopyEntity> bookcopyEntityList) {
        if(bookcopyEntityList == null){
            return null;
        }
        List<BookCopyDTO> result = new ArrayList<>();
        bookcopyEntityList.forEach(bookcopyEntity -> result.add(toBookCopyDTO(bookcopyEntity)));
        return result;
    }

    @Override
    public GenreEntity toGenreEntity(GenreDTO genreDTO) {
        if(genreDTO == null){
            return null;
        }
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setGenreid(genreDTO.getGenreid());
        genreEntity.setType(genreDTO.getType());
        return genreEntity;
    }

    @Override
    public List<GenreEntity> toGenreEntityList(List<GenreDTO> genreDTOList) {
        if(genreDTOList == null){
            return null;
        }
        List<GenreEntity> result = new ArrayList<>();
        genreDTOList.forEach(genreDTO -> result.add(toGenreEntity(genreDTO)));
        return result;
    }

    @Override
    public GenreDTO toGenreDTO(GenreEntity genreEntity) {
        if(genreEntity == null){
            return null;
        }
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setGenreid(genreEntity.getGenreid());
        genreDTO.setType(genreEntity.getType());
        return genreDTO;
    }

    @Override
    public List<GenreDTO> toGenreDTOList(List<GenreEntity> genreEntityList) {
        if(genreEntityList == null){
            return null;
        }
        List<GenreDTO> result = new ArrayList<>();
        genreEntityList.forEach(genreEntity -> result.add(toGenreDTO(genreEntity)));
        return result;
    }

    @Override
    public BookstateEntity toBookStateEntity(BookStateDTO bookStateDTO) {
        if(bookStateDTO == null){
            return null;
        }
        BookstateEntity bookstateEntity = new BookstateEntity();
        bookstateEntity.setStateid(bookStateDTO.getStateid());
        bookstateEntity.setState(bookStateDTO.getState());
        return bookstateEntity;
    }

    @Override
    public List<BookstateEntity> toBookStateEntityList(List<BookStateDTO> bookStateDTOList) {
        if (bookStateDTOList == null){
            return null;
        }
        List<BookstateEntity> result = new ArrayList<>();
        bookStateDTOList.forEach(bookStateDTO -> result.add(toBookStateEntity(bookStateDTO)));
        return result;
    }

    @Override
    public BookStateDTO toBookStateDTO(BookstateEntity bookstateEntity) {
        if(bookstateEntity == null){
            return null;
        }
        BookStateDTO bookStateDTO = new BookStateDTO();
        bookStateDTO.setStateid(bookstateEntity.getStateid());
        bookStateDTO.setState(bookstateEntity.getState());
        return bookStateDTO;
    }

    @Override
    public BookEntity toBookEntity(BookDTO bookDTO) {
        if(bookDTO == null){
            return null;
        }
        BookEntity bookEntity = new BookEntity();
        bookEntity.setIsbn(bookDTO.getIsbn());
        bookEntity.setAuthor(bookDTO.getAuthorid());
        bookEntity.setBookByAuthor(toAuthorEntity(bookDTO.getAuthorDTO()));
        bookEntity.setTitle(bookDTO.getTitle());
        bookEntity.setPages(bookDTO.getPages());
        bookEntity.setGenre(bookDTO.getGenreid());
        bookEntity.setBookByGenre(toGenreEntity(bookDTO.getGenreDTO()));
        bookEntity.setPublisher(bookDTO.getPublisher());
        return bookEntity;
    }

    @Override
    public List<BookEntity> toBookEntityList(List<BookDTO> bookDTOList) {
        if(bookDTOList == null){
            return null;
        }
        List<BookEntity> result = new ArrayList<>();
        bookDTOList.forEach(bookDTO -> result.add(toBookEntity(bookDTO)));
        return result;
    }

    @Override
    public BookDTO toBookDTO(BookEntity bookEntity) {
        if (bookEntity == null){
            return null;
        }
        BookDTO bookDTO = new BookDTO();
        bookDTO.setIsbn(bookEntity.getIsbn());
        bookDTO.setAuthorid(bookEntity.getAuthor());
        bookDTO.setTitle(bookEntity.getTitle());
        bookDTO.setPages(bookEntity.getPages());
        bookDTO.setPublisher(bookEntity.getPublisher());
        bookDTO.setAuthorDTO(toAuthorDTO(bookEntity.getBookByAuthor()));
        bookDTO.setGenreDTO(toGenreDTO(bookEntity.getBookByGenre()));
        bookDTO.setGenreid(bookEntity.getGenre());
        return bookDTO;
    }

    @Override
    public List<BookDTO> toBookDTOList(List<BookEntity> bookEntityList) {
        if (bookEntityList == null){
            return null;
        }
        List<BookDTO> result = new ArrayList<>();
        bookEntityList.forEach(bookEntity -> result.add(toBookDTO(bookEntity)));
        return result;
    }
}
