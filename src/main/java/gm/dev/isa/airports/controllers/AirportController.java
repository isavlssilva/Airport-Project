package gm.dev.isa.airports.controllers;

import gm.dev.isa.airports.DTO.AirportMinDTO;
import gm.dev.isa.airports.entities.Airport;
import gm.dev.isa.airports.service.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */
@RestController
public class AirportController {

    @Autowired
    private AirportService airportService;

    //*Endpoint /airports/airport
    //Retorna TODOS os aeroportos de base de dados
    //@Return
    @GetMapping("/airport")
    public List<Airport> findAll() {
        List<Airport> result = airportService.findAll();
        return result;

    }

    @GetMapping("/city/{cityName}")
    public List<Airport> findByIgnoreCase(@PathVariable String cityName) {
        List<Airport> result = airportService.findByCity(cityName);

        if (result.isEmpty()) {
            //Lista Vazia
            //404
            return (List<Airport>) ResponseEntity.notFound().build();
        } else {
            //Eba! tem dados!
            //ok devolve 200
            return (List<Airport>) ResponseEntity.ok(result);

        }
        //return result;

    }

    @GetMapping("/country/{countryName}")
    public ResponseEntity<List<AirportMinDTO>> findByCountryIgnoreCase(@PathVariable String countryName) {

        List<AirportMinDTO> result = airportService.findByCountry(countryName);
        if (result.isEmpty()) {
            //OPS lista vazia
            //notFound devolve 404
            return ResponseEntity.notFound().build();
        } else {
            return  ResponseEntity.ok(result);
        }
    }

}
