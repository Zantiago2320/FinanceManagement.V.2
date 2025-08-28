package com.app.FinanceManagement.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class CapitalizationSettingsDTO {
    private long idCapitalizationSettings;
    private BigDecimal interestRate;
    private String capitalizationFrequency;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public long getId() {
        return idCapitalizationSettings;
    }
}
