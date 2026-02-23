package gm.dev.isa.airports.service;

import gm.dev.isa.airports.entities.Airport;
import gm.dev.isa.airports.repositories.AirportRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digma
 */
@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> findAll() {

        List<Airport> result = airportRepository.findAll();
        return result;

    }
}
