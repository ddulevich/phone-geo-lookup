package com.dds.phones.service.init;

import com.dds.phones.mapper.CountryCodeMapper;
import com.dds.phones.repository.CountryCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CountryCodesInitialUploadService {

    private final CountryCodesDownloadService countryCodesDownloadService;
    private final CountryCodeRepository repository;
    private final CountryCodeMapper countryMapper;

    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent(ContextRefreshedEvent event) {
        event.getApplicationContext().getBean(CountryCodesInitialUploadService.class).init();
    }

    @Transactional
    public void init(){
        repository.deleteAll();
        repository.saveAll(countryMapper.map(countryCodesDownloadService.getCountryCodes()));
    }
}
