package com.dds.phones.repository;

import com.dds.phones.entity.CountryCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountryCodeRepository extends JpaRepository<CountryCodeEntity, Long> {
    @Query(nativeQuery = true, value = """
            select string_agg(name, ',') from countries where :phone like code || '%'
            group by length(code)
            order by length(code) DESC
            limit 1""")
    String findCountriesByPhone(String phone);
}
