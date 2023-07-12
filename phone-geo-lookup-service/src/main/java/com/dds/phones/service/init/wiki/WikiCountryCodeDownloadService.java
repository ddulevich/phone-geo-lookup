package com.dds.phones.service.init.wiki;

import com.dds.phones.dto.CountryCodeDto;
import com.dds.phones.service.init.CountryCodesDownloadService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class WikiCountryCodeDownloadService implements CountryCodesDownloadService {

    public static final String URL = "https://en.wikipedia.org/wiki/List_of_country_calling_codes";

    @Override
    public List<CountryCodeDto> getCountryCodes() {
        final List<CountryCodeDto> countries = new ArrayList<>();
        getRows().stream()
                .map(getColumns())
                .filter(isCountry())
                .forEach(element -> parseCountry(countries, element));
        return countries;
    }

    private Elements getRows() {
        try {
            return Jsoup.connect(URL)
                    .get()
                    .select("table.wikitable")
                    .get(1)
                    .select("tbody")
                    .select("tr");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Function<Element, Elements> getColumns() {
        return row -> row.select("td");
    }

    private Predicate<Elements> isCountry() {
        return columns -> columns.size() > 2 && StringUtils.isNotBlank(columns.get(2).text());
    }

    private void parseCountry(List<CountryCodeDto> countries, Elements element) {
        final String country = getCountry(element);
        final List<String> codes = getCodes(element);
        codes.forEach(code -> countries.add(new CountryCodeDto().setName(country).setCode(code)));
    }

    private String getCountry(Elements columns) {
        return columns.get(0).text();
    }

    private List<String> getCodes(Elements columns) {
        final String text = columns.get(1).text();
        final String mainCode = StringUtils.substringBefore(text, " ");
        final String addCodes = StringUtils.substringBetween(text, "(", ")");
        if (Objects.nonNull(addCodes)) {
            return Arrays.stream(addCodes.split(","))
                    .map(String::trim)
                    .map(addCode -> mainCode + addCode)
                    .collect(Collectors.toList());
        } else {
            return Collections.singletonList(mainCode);
        }
    }
}
