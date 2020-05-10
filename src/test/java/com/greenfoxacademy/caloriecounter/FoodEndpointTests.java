package com.greenfoxacademy.caloriecounter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FoodEndpointTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getFoodsShouldReturnCorrectFoods() throws Exception {
    // INSERT test data

//    mockMvc.perform(post("/api/foods")
//              .contentType(MediaType.APPLICATION_JSON)
//              .content("{\n" +
//                      "\t\"name\": \"Awesome Test Food\",\n" +
//                      "\t\"amount\": 600\n" +
//                      "}")
//            )
//            .andExpect(status().isOk());

    mockMvc.perform(get("/api/foods"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name", is("Chicken brest")));
  }
}
