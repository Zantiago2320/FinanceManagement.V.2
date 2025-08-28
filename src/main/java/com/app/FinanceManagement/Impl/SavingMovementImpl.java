package com.app.FinanceManagement.Impl;

import com.app.FinanceManagement.DTO.SavingMovementDTO;
import com.app.FinanceManagement.Repository.SavingMovementRepository;
import com.app.FinanceManagement.Entity.SavingMovement;
import com.app.FinanceManagement.Service.SavingMovementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SavingMovementImpl implements SavingMovementService {

    private final SavingMovementRepository savingMovementRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SavingMovementImpl(SavingMovementRepository savingMovementRepository, ModelMapper modelMapper) {
        this.savingMovementRepository = savingMovementRepository;
        this.modelMapper = modelMapper;
    }

    public SavingMovementDTO createSavingMovement(SavingMovementDTO movementDTO) {
        SavingMovement movement = modelMapper.map(movementDTO, SavingMovement.class);
        LocalDateTime now = LocalDateTime.now();
        if (movement.getMovementDate() == null) movement.setMovementDate(now);
        if (movement.getCreatedAt() == null) movement.setCreatedAt(now);
        if (movement.getUpdateAt() == null) movement.setUpdateAt(now);
        movement = savingMovementRepository.save(movement);
        return modelMapper.map(movement, SavingMovementDTO.class);
    }

    public SavingMovementDTO getSavingMovementById(long id) {
        SavingMovement movement = savingMovementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SavingMovement not found with id: " + id));
        return modelMapper.map(movement, SavingMovementDTO.class);
    }

    public List<SavingMovementDTO> getAllSavingMovements() {
        List<SavingMovement> movements = savingMovementRepository.findAll();
        return movements.stream()
                .map(movement -> modelMapper.map(movement, SavingMovementDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public SavingMovementDTO updateSavingMovement(long id, SavingMovementDTO movementDTO) {
        SavingMovement movement = savingMovementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SavingMovement not found with id: " + id));
        movement.setAmount(movementDTO.getAmount());
        movement.setMovementType(movementDTO.getMovementType());
        movement.setMovementDate(movementDTO.getMovementDate());
        movement.setCreatedAt(movementDTO.getCreatedAt());
        movement.setUpdateAt(movementDTO.getUpdateAt());
        SavingMovement updatedMovement = savingMovementRepository.save(movement);
        return modelMapper.map(updatedMovement, SavingMovementDTO.class);
    }

    public void deleteSavingMovement(long id) {
        if (!savingMovementRepository.existsById(id)) {
            throw new RuntimeException("SavingMovement not found with id: " + id);
        }
        savingMovementRepository.deleteById(id);
    }
}
