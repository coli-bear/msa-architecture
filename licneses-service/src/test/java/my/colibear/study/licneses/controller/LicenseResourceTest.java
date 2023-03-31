package my.colibear.study.licneses.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class LicenseResourceTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getLicenseTest() throws Exception {
        this.mockMvc.perform(get("/v1/organizations/1/licenses/2").contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.licenseId", is("2")))
            .andExpect(jsonPath("$.organizationId", is("1")))
            .andExpect(jsonPath("$.productName", is("Teleco")))
            .andExpect(jsonPath("$.licenseType", is("Seat")))
        ;
    }
}