package pl.polsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.dto.ReservationDTO;
import pl.polsl.service.ReservationService;

import java.util.List;

/**
 * Created by Katarzyna on 30.11.2016.
 */
@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<ReservationDTO>> getAllReservations(){
        List<ReservationDTO> reservationDTOs = reservationService.findAllReservations();
        return new ResponseEntity<List<ReservationDTO>>(reservationDTOs, HttpStatus.OK);
    }

    @RequestMapping(value = "/find/{card}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<ReservationDTO>> getReaderReservations(@PathVariable long card){
        List<ReservationDTO> reservationDTOs = reservationService.findUserReservations(card);
        return new ResponseEntity<List<ReservationDTO>>(reservationDTOs,HttpStatus.OK);
    }
}
