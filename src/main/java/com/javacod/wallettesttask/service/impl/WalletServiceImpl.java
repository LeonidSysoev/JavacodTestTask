package com.javacod.wallettesttask.service.impl;

import com.javacod.wallettesttask.dto.WalletDto;
import com.javacod.wallettesttask.exception.InsufficientFundsException;
import com.javacod.wallettesttask.exception.WalletNotFoundException;
import com.javacod.wallettesttask.mapper.WalletMapper;
import com.javacod.wallettesttask.model.Wallet;
import com.javacod.wallettesttask.repository.WalletRepository;
import com.javacod.wallettesttask.service.WalletService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor

public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;

    @Transactional
    @Override
    public WalletDto updateWallet(WalletDto walletDto) {
        Wallet wallet = findWallet(walletDto.getWalletId());
        log.info("Wallet {} is found", wallet.getWalletId());
        switch (walletDto.getOperationType()) {
            case DEPOSIT -> {
                wallet.setAmount(walletDto.getAmount().add(wallet.getAmount()));
                log.info("The deposit has been updated");
            }
            case WITHDRAW -> {
                if (wallet.getAmount().subtract(walletDto.getAmount()).compareTo(BigDecimal.ZERO) < 0) {
                    throw new InsufficientFundsException("Insufficient funds in the wallet");
                } else {
                    wallet.setAmount(walletDto.getAmount().subtract(wallet.getAmount()));
                    log.info("Withdrawal from the wallet");
                }
            }
        }
        walletRepository.save(wallet);
        return WalletMapper.INSTANCE.toDTO(wallet);

    }

    @Override
    public BigDecimal getWalletBalance(UUID wallteId) {
        Wallet wallet = findWallet(wallteId);
        log.info("balance received");
        return wallet.getAmount();
    }


    private Wallet findWallet(UUID walletId) {
        return walletRepository.findByWalletId(walletId)
                .orElseThrow(() -> new WalletNotFoundException("Wallet not found: " + walletId));
    }

}
