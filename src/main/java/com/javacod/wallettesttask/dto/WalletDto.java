package com.javacod.wallettesttask.dto;

import com.javacod.wallettesttask.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class WalletDto {
    private UUID walletId;
    private OperationType operationType;
    private BigDecimal amount;

}
