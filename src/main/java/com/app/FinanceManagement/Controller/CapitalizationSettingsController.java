package com.app.FinanceManagement.Controller;

import com.app.FinanceManagement.DTO.CapitalizationSettingsDTO;
import com.app.FinanceManagement.Service.CapitalizationSettingsService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/capitalizationsettings")
public class CapitalizationSettingsController {

    private final CapitalizationSettingsService capitalizationSettingsService;

    public CapitalizationSettingsController(CapitalizationSettingsService capitalizationSettingsService) {
        this.capitalizationSettingsService = capitalizationSettingsService;
    }

    // Endpoint to get all capitalization settings / Punto final para obtener todas las configuraciones de capitalización
    @GetMapping("/all")
    public ResponseEntity<List<CapitalizationSettingsDTO>> getAllCapitalizationSettings() {
        List<CapitalizationSettingsDTO> settings = capitalizationSettingsService.getAllCapitalizationSettings();
        return ResponseEntity.ok(settings);
    }

    // Endpoint to create a new capitalization setting / Punto final para crear una nueva configuración de capitalización
    @PostMapping("/create")
    public ResponseEntity<CapitalizationSettingsDTO> createCapitalizationSettings(@Validated @RequestBody CapitalizationSettingsDTO settingsDTO) {
        CapitalizationSettingsDTO createdSettings = capitalizationSettingsService.createCapitalizationSettings(settingsDTO);
        return ResponseEntity.ok(createdSettings);
    }

    // Endpoint to get a capitalization setting by ID / Punto final para obtener una configuración de capitalización por ID
    @GetMapping("/{id}")
    public ResponseEntity<CapitalizationSettingsDTO> getCapitalizationSettingsById(@PathVariable long id) {
        CapitalizationSettingsDTO settings = capitalizationSettingsService.getCapitalizationSettingsById(id);
        return ResponseEntity.ok(settings);
    }

    // Endpoint to update a capitalization setting / Punto final para actualizar una configuración de capitalización
    @PutMapping("/update/{id}")
    public ResponseEntity<CapitalizationSettingsDTO> updateCapitalizationSettings(@PathVariable long id, @Validated @RequestBody CapitalizationSettingsDTO settingsDTO) {
        CapitalizationSettingsDTO updatedSettings = capitalizationSettingsService.updateCapitalizationSettings(id, settingsDTO);
        return ResponseEntity.ok(updatedSettings);
    }

    // Endpoint to delete a capitalization setting / Punto final para eliminar una configuración de capitalización
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCapitalizationSettings(@PathVariable long id) {
        capitalizationSettingsService.deleteCapitalizationSettings(id);
        return ResponseEntity.noContent().build();
    }
}
