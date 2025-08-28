package com.app.FinanceManagement.Impl;

import com.app.FinanceManagement.DTO.FinancialProjectionDTO;
import com.app.FinanceManagement.Repository.FinancialProjectionRepository;
import com.app.FinanceManagement.Entity.FinancialProjection;
import com.app.FinanceManagement.Service.FinancialProjectionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialProjectionImpl implements FinancialProjectionService {

    private final FinancialProjectionRepository financialProjectionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FinancialProjectionImpl(FinancialProjectionRepository financialProjectionRepository, ModelMapper modelMapper) {
        this.financialProjectionRepository = financialProjectionRepository;
        this.modelMapper = modelMapper;
    }

    public FinancialProjectionDTO createFinancialProjection(FinancialProjectionDTO projectionDTO) {
        FinancialProjection projection = modelMapper.map(projectionDTO, FinancialProjection.class);
        projection = financialProjectionRepository.save(projection);
        return modelMapper.map(projection, FinancialProjectionDTO.class);
    }

    public FinancialProjectionDTO getFinancialProjectionById(long id) {
        FinancialProjection projection = financialProjectionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FinancialProjection not found with id: " + id));
        return modelMapper.map(projection, FinancialProjectionDTO.class);
    }

    public List<FinancialProjectionDTO> getAllFinancialProjections() {
        List<FinancialProjection> projections = financialProjectionRepository.findAll();
        return projections.stream()
                .map(projection -> modelMapper.map(projection, FinancialProjectionDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }

    public FinancialProjectionDTO updateFinancialProjection(long id, FinancialProjectionDTO projectionDTO) {
        FinancialProjection projection = financialProjectionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FinancialProjection not found with id: " + id));
        projection.setProjectedIncome(projectionDTO.getProjectedIncome());
        projection.setProjectedExpenses(projectionDTO.getProjectedExpenses());
        projection.setProjectionDate(projectionDTO.getProjectionDate());
        projection.setCreatedAt(projectionDTO.getCreatedAt());
        projection.setUpdateAt(projectionDTO.getUpdateAt());
        FinancialProjection updatedProjection = financialProjectionRepository.save(projection);
        return modelMapper.map(updatedProjection, FinancialProjectionDTO.class);
    }

    public void deleteFinancialProjection(long id) {
        if (!financialProjectionRepository.existsById(id)) {
            throw new RuntimeException("FinancialProjection not found with id: " + id);
        }
        financialProjectionRepository.deleteById(id);
    }
}
