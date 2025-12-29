package by.pilipuk.spec.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class BaseControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    protected String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            fail("Failed to prepare expected JSON: " + e.getMessage());
            return "";
        }
    }

    protected void performGetRequest(String url, Object expectedDto) {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get(url))
                    .andExpectAll(
                            status().isOk(),
                            content().contentType(MediaType.APPLICATION_JSON),
                            content().json(toJson(expectedDto))
                    );
        } catch (Exception e) {
            fail("Error executing request perform by mockMvc: " + e.getMessage());
        }
    }

    protected void performGetRequest(String url, Object urlVariables, Object expectedDto) {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get(url, urlVariables))
                    .andExpectAll(
                            status().isOk(),
                            content().contentType(MediaType.APPLICATION_JSON),
                            content().json(toJson(expectedDto))
                    );
        } catch (Exception e) {
            fail("Error executing GET request with path variable: " + e.getMessage());
        }
    }

    protected void performPostRequest(String url, Object postDto) {
        try {
            mockMvc.perform(MockMvcRequestBuilders.post(url)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(toJson(postDto)))
                    .andExpect(status().isCreated());
        } catch (Exception e) {
            fail("Error executing POST request to " + url + ": " + e.getMessage());
        }
    }

    protected void performPostRequest(String url, Object requestBody, Object expectedDto, Map<String, String> queryParams) {
        try {
            var requestBuilder = MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(toJson(requestBody));
            queryParams.forEach(requestBuilder::queryParam);

            mockMvc.perform(requestBuilder)
                    .andExpectAll(
                            status().isOk(),
                            content().contentType(MediaType.APPLICATION_JSON),
                            content().json(toJson(expectedDto))
                    );
        } catch (Exception e) {
            fail("Error executing POST search request: " + e.getMessage());
        }
    }
}
