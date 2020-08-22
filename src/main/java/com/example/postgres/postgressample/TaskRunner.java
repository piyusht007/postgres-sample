package com.example.postgres.postgressample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

@Component
public class TaskRunner implements CommandLineRunner {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ConversionService conversionService;

    @Override
    public void run(String... args) {
        final String queryString = "SELECT latitude, longitude FROM tomtom_usa WHERE tile = :tile";
        final Query nativeQuery = entityManager.createNativeQuery(queryString);

        nativeQuery.setParameter("tile", "a44b8a2");
        nativeQuery.setMaxResults(1);

        final List<Object[]> results = nativeQuery.getResultList();
        final Location location = conversionService.convert(results.get(0), Location.class);
    }
}
