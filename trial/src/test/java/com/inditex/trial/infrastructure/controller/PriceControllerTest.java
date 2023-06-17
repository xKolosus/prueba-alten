package com.inditex.trial.infrastructure.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.inditex.trial.TrialApplication;
import com.inditex.trial.domain.service.PriceService;
import com.inditex.trial.infrastructure.controller.request.PriceRequest;
import com.inditex.trial.infrastructure.controller.response.PriceResponse;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.MOCK,
    classes = TrialApplication.class)
@AutoConfigureMockMvc
class PriceControllerTest {

  @Autowired private MockMvc mvc;

  @Autowired private PriceService service;

  @Test
  void getPriceWithInfoFilteredCase1() throws Exception {

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    PriceRequest request = new PriceRequest();
    request.setDate("2020-06-14T10:00:00.000");
    request.setProductId(BigInteger.valueOf(35455));
    request.setBrandId(BigInteger.valueOf(1));
    String requestAsJson = objectMapper.writeValueAsString(request);

    MvcResult result =
        mvc.perform(
                post("/prices/find-filtered")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestAsJson))
            .andReturn();

    PriceResponse response =
        objectMapper.readValue(result.getResponse().getContentAsString(), PriceResponse.class);

    assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    assertNotNull(response);
    assertEquals(
        BigDecimal.valueOf(35.50).setScale(2, RoundingMode.HALF_UP), response.getPriceCalculated());
  }

  @Test
  void getPriceWithInfoFilteredCase2() throws Exception {

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    PriceRequest request = new PriceRequest();
    request.setDate("2020-06-14T16:00:00.000");
    request.setProductId(BigInteger.valueOf(35455));
    request.setBrandId(BigInteger.valueOf(1));
    String requestAsJson = objectMapper.writeValueAsString(request);

    MvcResult result =
        mvc.perform(
                post("/prices/find-filtered")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestAsJson))
            .andReturn();

    PriceResponse response =
        objectMapper.readValue(result.getResponse().getContentAsString(), PriceResponse.class);

    assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    assertNotNull(response);
    assertEquals(BigDecimal.valueOf(25.45D), response.getPriceCalculated());
  }

  @Test
  void getPriceWithInfoFilteredCase3() throws Exception {

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    PriceRequest request = new PriceRequest();
    request.setDate("2020-06-14T21:00:00.000");
    request.setProductId(BigInteger.valueOf(35455));
    request.setBrandId(BigInteger.valueOf(1));
    String requestAsJson = objectMapper.writeValueAsString(request);

    MvcResult result =
        mvc.perform(
                post("/prices/find-filtered")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestAsJson))
            .andReturn();

    PriceResponse response =
        objectMapper.readValue(result.getResponse().getContentAsString(), PriceResponse.class);

    assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    assertNotNull(response);
    assertEquals(BigDecimal.valueOf(25.45D), response.getPriceCalculated());
  }

  @Test
  void getPriceWithInfoFilteredCase4() throws Exception {

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    PriceRequest request = new PriceRequest();
    request.setDate("2020-06-15T10:00:00.000");
    request.setProductId(BigInteger.valueOf(35455));
    request.setBrandId(BigInteger.valueOf(1));
    String requestAsJson = objectMapper.writeValueAsString(request);

    MvcResult result =
        mvc.perform(
                post("/prices/find-filtered")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestAsJson))
            .andReturn();

    PriceResponse response =
        objectMapper.readValue(result.getResponse().getContentAsString(), PriceResponse.class);

    assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    assertNotNull(response);
    assertEquals(BigDecimal.valueOf(30.50D).setScale(2, RoundingMode.HALF_UP), response.getPriceCalculated());
  }

  @Test
  void getPriceWithInfoFilteredCase5() throws Exception {

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    PriceRequest request = new PriceRequest();
    request.setDate("2020-06-16T21:00:00.000");
    request.setProductId(BigInteger.valueOf(35455));
    request.setBrandId(BigInteger.valueOf(1));
    String requestAsJson = objectMapper.writeValueAsString(request);

    MvcResult result =
        mvc.perform(
                post("/prices/find-filtered")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestAsJson))
            .andReturn();

    PriceResponse response =
        objectMapper.readValue(result.getResponse().getContentAsString(), PriceResponse.class);

    assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    assertNotNull(response);
    assertEquals(BigDecimal.valueOf(38.95D), response.getPriceCalculated());
  }
}
