package com.dds.phones.controller;

import com.dds.phones.AbstractBootTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneValidationControllerTest extends AbstractBootTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/csv/countries-by-phone.csv", numLinesToSkip = 1, delimiter = ',')
    public void test(String phone, String countries) {
        final ResponseEntity<String[]> response = restTemplate.getForEntity(
                "/lookup?phone={phone}",
                String[].class,
                Map.of("phone", phone)
        );
        assertEquals(countries, Arrays.toString(response.getBody()));
    }
}
