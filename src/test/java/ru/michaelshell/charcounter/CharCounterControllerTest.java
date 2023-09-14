package ru.michaelshell.charcounter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CharCounterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void charCount() throws Exception {
        mockMvc.perform(post("/api/count")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content("aaabbbbc")
                ).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.b").value(4))
                .andExpect(jsonPath("$.a").value(3))
                .andExpect(jsonPath("$.c").value(1));
    }
}
