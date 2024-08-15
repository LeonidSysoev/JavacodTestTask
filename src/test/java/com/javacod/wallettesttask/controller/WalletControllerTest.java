package com.javacod.wallettesttask.controller;

import com.javacod.wallettesttask.dto.WalletDtoRequest;
import com.javacod.wallettesttask.enums.OperationType;
import com.javacod.wallettesttask.service.WalletService;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WalletController.class)
class WalletControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    WalletService walletService;


    @Test
    void updateWalletTest() throws Exception {
        UUID walletId = UUID.randomUUID();
        OperationType operationType = OperationType.DEPOSIT;
        BigDecimal amount = BigDecimal.valueOf(100);
        JSONObject walletDtoRequestObj = new JSONObject();
        walletDtoRequestObj.put("walletId", walletId);
        walletDtoRequestObj.put("operationType", operationType);
        walletDtoRequestObj.put("amount", amount);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/wallet")
                        .content(walletDtoRequestObj.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void getBalanceTest() {
        UUID walletId = UUID.randomUUID();
        when(walletService.getWalletBalance(walletId)).thenReturn(BigDecimal.valueOf(1000));

    }
}