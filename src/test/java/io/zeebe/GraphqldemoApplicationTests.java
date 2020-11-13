package io.zeebe;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class GraphqldemoApplicationTests {

	@Autowired
    MockMvc mockMvc;

	/**
	 * this will pass
	 * @throws Exception
	 */
    @Test
    void listOfStaticscontentAsExpected() throws Exception {
        String expectedResponse = "{\"btn8\":\"value1\",\"btn9\":\"value1\","
        		+ "\"btn6\":\"value1\",\"btn7\":\"value1\",\"btn4\":\"value1\","
        		+ "\"btn5\":\"value1\",\"btn2\":\"value1\",\"btn3\":\"value1\","
        		+ "\"btn0\":\"value1\",\"btn1\":\"value1\"}";
        
        MvcResult result = mockMvc.perform(post("/graphql")
        		.with(jwt())
                .content("{\"query\":\"{statics}\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        		.andExpect(status().isOk())
        		.andExpect(jsonPath("$.data.statics").value(expectedResponse))
                .andReturn();
        
        
        //redundante
        jsonPath("$.data.statics").value(expectedResponse).match(result);
               
    }
    
}
