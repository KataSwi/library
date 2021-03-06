package pl.polsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.dto.ReservationDTO;
import pl.polsl.mapper.LibraryMapper;
import pl.polsl.model.ReservationEntity;
import pl.polsl.repository.ReservationRepository;

import java.util.List;

/**
 * Created by Katarzyna on 30.12.2016.
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    public List<ReservationDTO> findAllReservations() {
        List<ReservationEntity> reservationEntities = reservationRepository.findAll();
        List<ReservationDTO> reservationDTOs = libraryMapper.toReservationDTOList(reservationEntities);
        return reservationDTOs;
    }

    @Override
    public List<ReservationDTO> findUserReservations(long readerCard) {
        List<ReservationEntity> reservationEntities = reservationRepository.findByReaderCard(readerCard);
        List<ReservationDTO> reservationDTOs = libraryMapper.toReservationDTOList(reservationEntities);
        return reservationDTOs;
    }

    @Override
    public ReservationDTO findUserReservationById(int reservationid, int state) {
        ReservationEntity reservationEntity = reservationRepository.findByReservationidAndReservationState(reservationid,state);
        return libraryMapper.toReservationDTO(reservationEntity);
    }
}
