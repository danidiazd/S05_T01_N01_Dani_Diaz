package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.controller;

import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.dto.CountryWorld;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountryController {


    @GetMapping("/countries")
    public ResponseEntity<List<String>> getCountries() {
        List<String> countries = Arrays.stream(CountryWorld.values())
                .map(Enum::name)
                .collect(Collectors.toList());

        return ResponseEntity.ok(countries);
    }
}
