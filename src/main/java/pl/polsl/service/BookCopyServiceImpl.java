package pl.polsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.dto.BookCopyDTO;
import pl.polsl.mapper.BookMapper;
import pl.polsl.model.BookcopyEntity;
import pl.polsl.repository.BookCopyRepository;

import java.util.List;

/**
 * Created by Katarzyna on 17.12.2016.
 */
@Service
public class BookCopyServiceImpl implements BookCopyService {

    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Autowired
    private BookMapper bookMapper;


    @Override
    public BookCopyDTO createBookCopy(BookCopyDTO bookCopyDTO) {
        if (bookCopyDTO == null){
            return null;
        }
        BookcopyEntity bookcopyEntity = bookMapper.toBookCopyEntity(bookCopyDTO);
        bookcopyEntity = bookCopyRepository.save(bookcopyEntity);
        return bookMapper.toBookCopyDTO(bookcopyEntity);
    }

    @Override
    public List<BookCopyDTO> findAllBookCopies() {
        List<BookcopyEntity> bookcopyEntities = bookCopyRepository.findAll();
        return bookMapper.toBookCopyDTOList(bookcopyEntities);
    }

    @Override
    public BookCopyDTO findByInventoryNumber(long id) {
        BookcopyEntity bookcopyEntity = bookCopyRepository.findByInventory(id);
        return bookMapper.toBookCopyDTO(bookcopyEntity);
    }

    @Override
    public List<BookCopyDTO> findBookCopiesByIsbn(String isbn) {
        List<BookcopyEntity> bookcopyEntities = bookCopyRepository.findByIsbn(isbn);
        return bookMapper.toBookCopyDTOList(bookcopyEntities);
    }

    @Override
    public List<BookCopyDTO> findBookCopiesByState(String isbn, int state) {
        List<BookcopyEntity> bookcopyEntities = bookCopyRepository.findByStateAndIsbn(state,isbn);
        return bookMapper.toBookCopyDTOList(bookcopyEntities);
    }
}
