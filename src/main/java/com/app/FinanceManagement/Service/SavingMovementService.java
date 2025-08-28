package com.app.FinanceManagement.Service;

import com.app.FinanceManagement.DTO.SavingMovementDTO;
import com.app.FinanceManagement.Entity.SavingMovement;

import java.util.List;

public interface SavingMovementService {
    SavingMovementDTO createSavingMovement(SavingMovementDTO movementDTO);
    SavingMovementDTO getSavingMovementById(long id);
    List<SavingMovementDTO> getAllSavingMovements();
    SavingMovementDTO updateSavingMovement(long id, SavingMovementDTO movementDTO);
    void deleteSavingMovement(long id);
}
