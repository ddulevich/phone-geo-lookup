package com.dds.phones.service.init;

import com.dds.phones.dto.CountryCodeDto;

import java.util.List;

public interface CountryCodesDownloadService {
    List<CountryCodeDto> getCountryCodes();
}
