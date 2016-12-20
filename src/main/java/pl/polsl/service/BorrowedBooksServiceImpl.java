package pl.polsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.dto.BorrowedBooksDTO;
import pl.polsl.mapper.LibraryMapper;
import pl.polsl.model.BorrowedbooksEntity;
import pl.polsl.repository.BorrowedBooksRepository;

import java.util.List;

/**
 * Created by Katarzyna on 18.12.2016.
 */
@Service
public class BorrowedBooksServiceImpl implements BorrowedBooksService {

    @Autowired
    private BorrowedBooksRepository borrowedBooksRepository;

    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    public BorrowedBooksDTO addNewBorrowing(BorrowedBooksDTO borrowedBooksDTO) {
        if(borrowedBooksDTO == null){
            return null;
        }
        BorrowedbooksEntity borrowedbooksEntity = libraryMapper.toBorrowedBooksEntity(borrowedBooksDTO);
        borrowedbooksEntity = borrowedBooksRepository.save(borrowedbooksEntity);
        return libraryMapper.toBorrowedBooksDTO(borrowedbooksEntity);
    }

    @Override
    public List<BorrowedBooksDTO> findAllBorrowings() {
        List<BorrowedbooksEntity> borrowings = borrowedBooksRepository.findAll();
        return libraryMapper.toBorrowedBooksDTOList(borrowings);
    }
}
