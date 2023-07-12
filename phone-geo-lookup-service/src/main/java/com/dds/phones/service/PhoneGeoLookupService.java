package com.dds.phones.service;

import com.dds.phones.repository.CountryCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.dds.phones.utils.Constants.DELIMITER;
import static com.dds.phones.utils.PhoneCleaner.cleanPhoneNumber;
import static com.dds.phones.utils.PhoneValidator.validatePhoneNumber;

@Service
@RequiredArgsConstructor
public class PhoneGeoLookupService {
    private final CountryCodeRepository repository;

    public List<String> getCountriesByPhone(final String phone) {
        validatePhoneNumber(phone);
        return getCountries(cleanPhoneNumber(phone));
    }

    private List<String> getCountries(String cleanedPhoneNumber) {
        final String countriesByPhone = repository.findCountriesByPhone(cleanedPhoneNumber);
        if (Objects.nonNull(countriesByPhone)) {
            return List.of(countriesByPhone.split(DELIMITER));
        } else{
            throw new RuntimeException("Countries not found");
        }
    }
}
