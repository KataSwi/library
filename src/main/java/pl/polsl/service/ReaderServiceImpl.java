package pl.polsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.dto.ReaderDTO;
import pl.polsl.mapper.LibraryMapper;
import pl.polsl.model.ReaderEntity;
import pl.polsl.repository.ReaderRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katarzyna on 06.12.2016.
 */
@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    public List<ReaderDTO> findAllReaders() {
        List<ReaderEntity> readers = readerRepository.findAll();
        List<ReaderDTO> result = libraryMapper.toReaderDTOList(readers);
        return result;
    }

    @Override
    public ReaderDTO findReaderByCardNumber(long cardNumber) {
        ReaderEntity readerEntity = readerRepository.findOne(cardNumber);
        return libraryMapper.toReaderDTO(readerEntity);
    }

    @Override
    public ReaderDTO findReaderByUserName(String userName) {
        ReaderEntity readerEntity = readerRepository.findByUserName(userName);
        return libraryMapper.toReaderDTO(readerEntity);
    }
}
