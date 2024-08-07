package com.javacod.wallettesttask.service;

import com.javacod.wallettesttask.dto.WalletDto;

import java.math.BigDecimal;
import java.util.UUID;

public interface WalletService {
    WalletDto updateWallet(WalletDto walletDto);

    BigDecimal getWalletBalance(UUID wallteId);

}
