
package gm.dev.isa.airports.repositories;

import gm.dev.isa.airports.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author digma
 */
public interface AirportRepository extends JpaRepository<Airport, Long>{
    
}
