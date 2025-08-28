package com.app.FinanceManagement.Controller;

import com.app.FinanceManagement.DTO.SavingMovementDTO;
import com.app.FinanceManagement.Service.SavingMovementService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/savingmovements")
public class SavingMovementController {

    private final SavingMovementService savingMovementService;

    public SavingMovementController(SavingMovementService savingMovementService) {
        this.savingMovementService = savingMovementService;
    }

    // Endpoint to get all saving movements / Punto final para obtener todos los movimientos de ahorro
    @GetMapping("/all")
    public ResponseEntity<List<SavingMovementDTO>> getAllSavingMovements() {
        List<SavingMovementDTO> movements = savingMovementService.getAllSavingMovements();
        return ResponseEntity.ok(movements);
    }

    // Endpoint to create a new saving movement / Punto final para crear un nuevo movimiento de ahorro
    @PostMapping("/create")
    public ResponseEntity<SavingMovementDTO> createSavingMovement(@Validated @RequestBody SavingMovementDTO movementDTO) {
        SavingMovementDTO createdMovement = savingMovementService.createSavingMovement(movementDTO);
        return ResponseEntity.ok(createdMovement);
    }

    // Endpoint to get a saving movement by ID / Punto final para obtener un movimiento de ahorro por ID
    @GetMapping("/{id}")
    public ResponseEntity<SavingMovementDTO> getSavingMovementById(@PathVariable long id) {
        SavingMovementDTO movement = savingMovementService.getSavingMovementById(id);
        return ResponseEntity.ok(movement);
    }

    // Endpoint to update a saving movement / Punto final para actualizar un movimiento de ahorro
    @PutMapping("/update/{id}")
    public ResponseEntity<SavingMovementDTO> updateSavingMovement(@PathVariable long id, @Validated @RequestBody SavingMovementDTO movementDTO) {
        SavingMovementDTO updatedMovement = savingMovementService.updateSavingMovement(id, movementDTO);
        return ResponseEntity.ok(updatedMovement);
    }

    // Endpoint to delete a saving movement / Punto final para eliminar un movimiento de ahorro
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSavingMovement(@PathVariable long id) {
        savingMovementService.deleteSavingMovement(id);
        return ResponseEntity.noContent().build();
    }
}
