package gm.dev.isa.airports.service;

import gm.dev.isa.airports.DTO.AirportMinDTO;
import gm.dev.isa.airports.DTO.AirportNearMeDTO;
import gm.dev.isa.airports.entities.Airport;
import gm.dev.isa.airports.projections.AirportNearMeProjection;
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
    
    // Retorna DTO Airports filtrado por cidade 
    // @param city
    // @Return
    
     public List<Airport> findByCity(String city) {
        List<Airport> result = airportRepository.findByCityIgnoreCase(city);
        return result;
    }
    // Retorna DTO AirportsMinDto filtrado por country (pais)    
    // @param country
    // @Return
     
     public List<AirportMinDTO> findByCountry(String country){
         List<Airport> resultAirport = airportRepository.findByCountryIgnoreCase(country);
         
         List<AirportMinDTO> resultDTO = resultAirport.stream().map(x -> new AirportMinDTO(x)).toList();
         
         return resultDTO;
     }
     
     // Retorna DTO Airports por iataCode    
    // @param iataCode
    // @Return
     
     public Airport findByIataCode(String iataCode){
         Airport result = airportRepository.findByIataCode(iataCode);
         return result;
         
     }
     
     public List<AirportNearMeDTO> findNearMe(double latitude, double longitude){
         List<AirportNearMeProjection> resultNearAirports = airportRepository.findNearMe(latitude, longitude);
         
         List<AirportNearMeDTO> resultDTO = resultNearAirports.stream().map(x -> new AirportNearMeDTO(x)).toList();
         
         return resultDTO;
     }
     
     
}