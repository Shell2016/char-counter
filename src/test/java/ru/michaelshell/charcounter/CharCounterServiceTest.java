package ru.michaelshell.charcounter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.michaelshell.charcounter.service.CharCounterService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CharCounterServiceTest {

    private static final String STRING_TO_COUNT = "aaaa bbbbb \n\ncccccc %";
    private static final Map<Character, Long> EXPECTED_MAP = new LinkedHashMap<>() {{
        put('c', 6L);
        put('b', 5L);
        put('a', 4L);
        put(' ', 3L);
        put('\n', 2L);
        put('%', 1L);
    }};

    @Autowired
    private CharCounterService charCounterService;

    @Test
    void checkCountChars() {
        final Map<Character, Long> actualMap = charCounterService.countChars(STRING_TO_COUNT);

        assertThat(actualMap).isEqualTo(EXPECTED_MAP);
    }

    @Test
    void checkCountCharsOrdering() {
        final Map<Character, Long> actualMap = charCounterService.countChars(STRING_TO_COUNT);
        final List<Map.Entry<Character, Long>> actualList = new ArrayList<>(actualMap.entrySet());
        final List<Map.Entry<Character, Long>> expectedList = new ArrayList<>(EXPECTED_MAP.entrySet());

        assertThat(actualList).isEqualTo(expectedList);
    }
}
