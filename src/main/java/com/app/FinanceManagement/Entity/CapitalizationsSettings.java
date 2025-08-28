package com.app.FinanceManagement.Entity;

import com.app.FinanceManagement.DTO.CapitalizationSettingsDTO;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "CapitalizationSettings")
@Data
public abstract class CapitalizationsSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ide_capitalization_settings", nullable = false, unique = true)
    private long idCapitalizationSettings;

    @Column(name = "interest_rate", nullable = false)
    private BigDecimal interestRate;

    @Column(name = "capitalization_frequency", nullable = false)
    private String capitalizationFrequency;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    public abstract CapitalizationSettingsDTO createCapitalizationSettings(CapitalizationSettingsDTO settingsDTO);

    public abstract CapitalizationSettingsDTO getCapitalizationSettingsById(long id);

    public abstract List<CapitalizationSettingsDTO> getAllCapitalizationSettings();

    public abstract CapitalizationSettingsDTO updateCapitalizationSettings(long id, CapitalizationSettingsDTO settingsDTO);

    public abstract void deleteCapitalizationSettings(long id);
}
