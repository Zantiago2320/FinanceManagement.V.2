package com.app.FinanceManagement.Config;

import com.app.financeManagement.DTO.TransactionDTO;
import com.app.financeManagement.Entity.Transaction;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.context.annotation.Bean;
@org.springframework.context.annotation.Configuration

public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true);

        // Mapeo personalizado: Transaction -> TransactionDTO
        modelMapper.typeMap(Transaction.class, TransactionDTO.class)
                .addMappings(mapper -> {
                    mapper.map(src -> src.getUser().getIdUser(), TransactionDTO::setUserId);
                    mapper.map(src -> src.getCategory().getIdCategory(), TransactionDTO::setIdCategory);
                });

        return modelMapper;
    }
}