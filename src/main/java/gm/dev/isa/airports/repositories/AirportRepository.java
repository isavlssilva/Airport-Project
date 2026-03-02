package gm.dev.isa.airports.repositories;

import gm.dev.isa.airports.entities.Airport;
import gm.dev.isa.airports.projections.AirportNearMeProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author digma
 */
public interface AirportRepository extends JpaRepository<Airport, Long> {

    List<Airport> findByCityIgnoreCase(String city);

    List<Airport> findByCountryIgnoreCase(String country);

    Airport findByIataCode(String iatacode);
    
    @Query(nativeQuery = true, value = """
                                       SELECT
                                        airport.id,
                                        airport.name,
                                        airport.city,
                                        airport.iatacode,
                                        airport.latitude,
                                        airport.longitude,
                                        airport.altitude,
                                        SQRT(
                                        power(airport.latitude - :latOrigem, 2 ) +
                                        power(airport.longitude -:lonOrigem, 2)) * 60 * 1.852 as
                                       distanciaKM
                                       from AIRPORT
                                       order by distanciaKM
                                       limit 10;"""     )
    List<AirportNearMeProjection> findNearMe(double latOrigem, double lonOrigem);
    
    

}
