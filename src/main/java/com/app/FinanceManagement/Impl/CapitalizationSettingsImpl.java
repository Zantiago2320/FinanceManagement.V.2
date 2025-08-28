package com.app.FinanceManagement.Impl;

import com.app.FinanceManagement.DTO.CapitalizationSettingsDTO;

import java.util.List;

import com.app.FinanceManagement.Service.CapitalizationSettingsService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class CapitalizationSettingsImpl implements CapitalizationSettingsService {

    private final List<CapitalizationSettingsDTO> fakeDb = new ArrayList<>();

    @Override
    public List<CapitalizationSettingsDTO> getAllCapitalizationSettings() {
        return fakeDb;
    }

    @Override
    public CapitalizationSettingsDTO createCapitalizationSettings(CapitalizationSettingsDTO dto) {
        fakeDb.add(dto);
        return dto;
    }

    @Override
    public CapitalizationSettingsDTO getCapitalizationSettingsById(long id) {
        return fakeDb.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public CapitalizationSettingsDTO updateCapitalizationSettings(long id, CapitalizationSettingsDTO dto) {
        deleteCapitalizationSettings(id);
        fakeDb.add(dto);
        return dto;
    }

    @Override
    public void deleteCapitalizationSettings(long id) {
        fakeDb.removeIf(s -> s.getId() == id);
    }
}
