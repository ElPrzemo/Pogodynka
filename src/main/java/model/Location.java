package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    private static AtomicInteger idCounter = new AtomicInteger(0);
    private int id;
    private String city;
    private double latitude;
    private double longitude;
    private String country;

    public Location(String city, String country, double latitude, double longitude) {
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.id = idCounter.incrementAndGet();
    }
}


