package com.javacod.wallettesttask.mapper;

import com.javacod.wallettesttask.dto.WalletDto;
import com.javacod.wallettesttask.model.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WalletMapper {
    WalletMapper INSTANCE = Mappers.getMapper(WalletMapper.class);

    @Mapping(source = "wallet.walletId", target = "walletId")
    @Mapping(source = "wallet.amount", target = "amount")
    @Mapping(target = "operationType", ignore = true)
    WalletDto toDTO(Wallet wallet);
}
