package ru.michaelshell.charcounter.service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Service
public class CharCounterService {

    public Map<Character, Long> countChars(String string) {
        final Map<Character, Long> countMap = string.chars()
                .mapToObj(value -> (char) value)
                .collect(groupingBy(Function.identity(), counting()));
        return sortByValueDesc(countMap);
    }

    private Map<Character, Long> sortByValueDesc(Map<Character, Long> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
