/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.dev.isa.airports.DTO;

/**
 *
 * @author digma
 */
public class AirportNearMeDTO {
    
    private long id;
    private String name;
    private String city;
    private String iataCode;
    private String latitude;
    private String longitude;
    private String altitude;
    private String distanciaKM;

    public AirportNearMeDTO() {
    }

    public AirportNearMeDTO(long id, String name, String city, String iataCode, String latitude, String longitude, String altitude, String distanciaKM) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.iataCode = iataCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.distanciaKM = distanciaKM;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getIataCode() {
        return iataCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getAltitude() {
        return altitude;
    }

    public String getDistanciaKM() {
        return distanciaKM;
    }
    
}
