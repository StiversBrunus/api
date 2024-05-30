package br.com.redventures.ramengo.api.test.unit;

import br.com.redventures.ramengo.api.infra.Security;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class RamenGoUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_orders_end_point () throws Exception {

        mockMvc.perform(get("/orders").param("x-api-name", Security.AUTH_TOKEN))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string("Open Order Request!!!"));
    }
}
