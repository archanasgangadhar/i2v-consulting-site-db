package com.world.i2v.contactusapi.ipgeo;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class IpGeoService {

    private final RestTemplate restTemplate = new RestTemplate();

    // Example: https://ipinfo.io/{ip}?token=YOUR_TOKEN
    @Value("${ipgeo.api.url:https://ipinfo.io}")
    private String apiUrl;

    @Value("${ipgeo.api.key:}")
    private String apiKey;

    public Optional<Location> lookup(String ip) {
        try {
            if (apiKey == null || apiKey.isBlank()) {
                return Optional.empty(); // API key not configured
            }

            String url = apiUrl + "/" + ip + "?token=" + apiKey;
            System.out.println(url);

            ResponseEntity<IpInfoResponse> response =
                    restTemplate.getForEntity(url, IpInfoResponse.class);

            if (response.getBody() == null || response.getBody().loc == null) {
                return Optional.empty();
            }

            String[] parts = response.getBody().loc.split(",");
            double lat = Double.parseDouble(parts[0]);
            double lng = Double.parseDouble(parts[1]);

            return Optional.of(new Location(lat, lng));

        } catch (Exception e) {
            return Optional.empty();
        }
    }

    // ---------------- Inner DTOs ----------------

    public static class IpInfoResponse {
        public String ip;
        public String city;
        public String region;
        public String country;
        public String loc; // e.g. "23.8103,90.4125"
    }

    public static class Location {
        public final double lat;
        public final double lng;

        public Location(double lat, double lng) {
            this.lat = lat;
            this.lng = lng;
        }
    }
}
