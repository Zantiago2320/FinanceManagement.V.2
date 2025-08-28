package com.app.FinanceManagement.Service;

import com.app.FinanceManagement.DTO.CapitalizationSettingsDTO;

import java.util.List;

public interface CapitalizationSettingsService {
    List<CapitalizationSettingsDTO> getAllCapitalizationSettings();
    CapitalizationSettingsDTO createCapitalizationSettings(CapitalizationSettingsDTO dto);
    CapitalizationSettingsDTO getCapitalizationSettingsById(long id);
    CapitalizationSettingsDTO updateCapitalizationSettings(long id, CapitalizationSettingsDTO dto);
    void deleteCapitalizationSettings(long id);
}
