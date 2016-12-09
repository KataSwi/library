package pl.polsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.dto.BookDTO;
import pl.polsl.mapper.BookMapper;
import pl.polsl.model.BookEntity;
import pl.polsl.repository.BookRepository;

import java.util.List;

/**
 * Created by Katarzyna on 08.12.2016.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        if (bookDTO == null){
            return null;
        }
        BookEntity bookEntity = bookMapper.toBookEntity(bookDTO);
        bookEntity = bookRepository.save(bookEntity);
        return bookMapper.toBookDTO(bookEntity);
    }

    @Override
    public List<BookDTO> findAllBooks() {
        List<BookEntity> foundBooks = bookRepository.findAll();
        return bookMapper.toBookDTOList(foundBooks);
    }

    @Override
    public List<BookDTO> findBookByTitle(String title) {
        title = title.replace('_',' ');
        List<BookEntity> foundBooks = bookRepository.findByTitle(title);
        return bookMapper.toBookDTOList(foundBooks);
    }
}
