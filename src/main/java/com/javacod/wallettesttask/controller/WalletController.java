package com.javacod.wallettesttask.controller;

import com.javacod.wallettesttask.dto.WalletDto;
import com.javacod.wallettesttask.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @PostMapping("/wallet")
    public ResponseEntity<WalletDto> updateWallet(@Valid @RequestBody WalletDto walletDto) {
        return ResponseEntity.ok(walletService.updateWallet(walletDto));
    }

    @GetMapping("wallets/{WALLET_UUID}")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable UUID WALLET_UUID) {
        return ResponseEntity.ok(walletService.getWalletBalance(WALLET_UUID));
    }

}
