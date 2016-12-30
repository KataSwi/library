package pl.polsl.service;

import pl.polsl.dto.ReservationDTO;

import java.util.List;

/**
 * Created by Katarzyna on 30.12.2016.
 */
public interface ReservationService {
    ReservationDTO addReservation(ReservationDTO reservationDTO);
    List<ReservationDTO> findAllReservations();
    List<ReservationDTO> findUserReservations(long readerCard);
}
