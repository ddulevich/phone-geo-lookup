package com.dds.phones.mapper;

import com.dds.phones.dto.CountryCodeDto;
import com.dds.phones.entity.CountryCodeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryCodeMapper {
    List<CountryCodeEntity> map(List<CountryCodeDto> rate);
}
