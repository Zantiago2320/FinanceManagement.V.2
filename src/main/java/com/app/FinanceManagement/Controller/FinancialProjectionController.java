package com.app.FinanceManagement.Controller;

import com.app.FinanceManagement.DTO.FinancialProjectionDTO;
import com.app.FinanceManagement.Service.FinancialProjectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/financialprojections")
public class FinancialProjectionController {

    private final FinancialProjectionService financialProjectionService;

    public FinancialProjectionController(FinancialProjectionService financialProjectionService) {
        this.financialProjectionService = financialProjectionService;
    }

    // Endpoint to get all financial projections / Punto final para obtener todas las proyecciones financieras
    @GetMapping("/all")
    public ResponseEntity<List<FinancialProjectionDTO>> getAllFinancialProjections() {
        List<FinancialProjectionDTO> projections = financialProjectionService.getAllFinancialProjections();
        return ResponseEntity.ok(projections);
    }

    // Endpoint to create a new financial projection / Punto final para crear una nueva proyección financiera
    @PostMapping("/create")
    public ResponseEntity<FinancialProjectionDTO> createFinancialProjection(@Validated @RequestBody FinancialProjectionDTO projectionDTO) {
        FinancialProjectionDTO createdProjection = financialProjectionService.createFinancialProjection(projectionDTO);
        return ResponseEntity.ok(createdProjection);
    }

    // Endpoint to get a financial projection by ID / Punto final para obtener una proyección financiera por ID
    @GetMapping("/{id}")
    public ResponseEntity<FinancialProjectionDTO> getFinancialProjectionById(@PathVariable long id) {
        FinancialProjectionDTO projection = financialProjectionService.getFinancialProjectionById(id);
        return ResponseEntity.ok(projection);
    }

    // Endpoint to update a financial projection / Punto final para actualizar una proyección financiera
    @PutMapping("/update/{id}")
    public ResponseEntity<FinancialProjectionDTO> updateFinancialProjection(@PathVariable long id, @Validated @RequestBody FinancialProjectionDTO projectionDTO) {
        FinancialProjectionDTO updatedProjection = financialProjectionService.updateFinancialProjection(id, projectionDTO);
        return ResponseEntity.ok(updatedProjection);
    }

    // Endpoint to delete a financial projection / Punto final para eliminar una proyección financiera
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFinancialProjection(@PathVariable long id) {
        financialProjectionService.deleteFinancialProjection(id);
        return ResponseEntity.noContent().build();
    }
}
