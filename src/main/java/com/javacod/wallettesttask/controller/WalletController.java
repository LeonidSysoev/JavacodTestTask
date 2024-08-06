package com.javacod.wallettesttask.controller;

import com.javacod.wallettesttask.dto.WalletDto;
import com.javacod.wallettesttask.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @PostMapping("/wallet")
    public ResponseEntity<WalletDto> updateWallet(@Valid @RequestBody WalletDto walletDto) {
        //return ResponseEntity.ok(walletService.updateWallet);
        return null;

    }

}
