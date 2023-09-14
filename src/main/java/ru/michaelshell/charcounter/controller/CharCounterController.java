package ru.michaelshell.charcounter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.michaelshell.charcounter.service.CharCounterService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CharCounterController {

    private final CharCounterService charCounterService;

    @GetMapping("/count")
    public ResponseEntity<Map<Character, Long>> countChars(@RequestBody String string) {
        return ResponseEntity.ok(charCounterService.countChars(string));
    }
}
