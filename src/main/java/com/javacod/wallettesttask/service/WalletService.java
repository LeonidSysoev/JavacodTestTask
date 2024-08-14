package com.javacod.wallettesttask.service;

import com.javacod.wallettesttask.dto.WalletDto;
import com.javacod.wallettesttask.dto.WalletDtoRequest;

import java.math.BigDecimal;
import java.util.UUID;

public interface WalletService {
    WalletDto updateWallet(WalletDtoRequest walletDtoRequest);

    BigDecimal getWalletBalance(UUID wallteId);

}
