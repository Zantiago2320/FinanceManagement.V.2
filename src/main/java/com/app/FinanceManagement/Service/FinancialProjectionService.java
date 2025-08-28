package com.app.FinanceManagement.Service;

import com.app.FinanceManagement.DTO.FinancialProjectionDTO;
import com.app.FinanceManagement.Entity.FinancialProjection;

import java.util.List;

public interface FinancialProjectionService {
    FinancialProjectionDTO createFinancialProjection(FinancialProjectionDTO projectionDTO);
    FinancialProjectionDTO getFinancialProjectionById(long id);
    List<FinancialProjectionDTO> getAllFinancialProjections();
    FinancialProjectionDTO updateFinancialProjection(long id, FinancialProjectionDTO projectionDTO);
    void deleteFinancialProjection(long id);
}
