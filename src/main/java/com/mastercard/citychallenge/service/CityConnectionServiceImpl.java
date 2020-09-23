package com.mastercard.citychallenge.service;

import com.mastercard.citychallenge.model.CityConnection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CityConnectionServiceImpl implements CityConnectionService {

    private List<CityConnection> cityConnectionList = new ArrayList<>();

    @Override
    public boolean routeExists(String origin, String destination) {
        if (!StringUtils.isEmpty(origin) && !StringUtils.isEmpty(destination)) {
            return cityConnectionList.stream().anyMatch(v -> origin.equalsIgnoreCase(v.getOrigin())
                    && destination.equalsIgnoreCase(v.getDestination()));
        }
        return false;

    }

    @PostConstruct
    public void loadCities() {
        ClassPathResource resource = new ClassPathResource("data/city.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            cityConnectionList = reader.lines().map(line -> line.split(",")).map(cities -> {
                CityConnection cityConnection = new CityConnection();
                if (cities.length == 2) {
                    cityConnection.setOrigin(cities[0].trim());
                    cityConnection.setDestination(cities[1].trim());
                }
                return cityConnection;
            }).collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }
}
