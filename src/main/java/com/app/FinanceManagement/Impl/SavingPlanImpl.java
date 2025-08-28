package com.app.FinanceManagement.Impl;

import com.app.FinanceManagement.DTO.SavingPlanDTO;
import com.app.FinanceManagement.Repository.SavingPlanRepository;
import com.app.FinanceManagement.Entity.SavingPlan;
import com.app.FinanceManagement.Service.SavingPlanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingPlanImpl implements SavingPlanService {

    private final SavingPlanRepository savingPlanRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SavingPlanImpl(SavingPlanRepository savingPlanRepository, ModelMapper modelMapper) {
        this.savingPlanRepository = savingPlanRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SavingPlanDTO createSavingPlan(SavingPlanDTO planDTO) {
        SavingPlan plan = modelMapper.map(planDTO, SavingPlan.class);
        plan = savingPlanRepository.save(plan);
        return modelMapper.map(plan, SavingPlanDTO.class);
    }

    @Override
    public SavingPlanDTO getSavingPlanById(long id) {
        SavingPlan plan = savingPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SavingPlan not found with id: " + id));
        return modelMapper.map(plan, SavingPlanDTO.class);
    }

    @Override
    public List<SavingPlanDTO> getAllSavingPlans() {
        List<SavingPlan> plans = savingPlanRepository.findAll();
        return plans.stream()
                .map(plan -> modelMapper.map(plan, SavingPlanDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public SavingPlanDTO updateSavingPlan(long id, SavingPlanDTO planDTO) {
        SavingPlan plan = savingPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SavingPlan not found with id: " + id));
        plan.setPlanName(planDTO.getPlanName());
        plan.setTargetAmount(planDTO.getTargetAmount());
        plan.setDurationMonths(planDTO.getDurationMonths());
        plan.setCreatedAt(planDTO.getCreatedAt());
        plan.setUpdateAt(planDTO.getUpdateAt());
        SavingPlan updatedPlan = savingPlanRepository.save(plan);
        return modelMapper.map(updatedPlan, SavingPlanDTO.class);
    }

    public void deleteSavingPlan(long id) {
        if (!savingPlanRepository.existsById(id)) {
            throw new RuntimeException("SavingPlan not found with id: " + id);
        }
        savingPlanRepository.deleteById(id);
    }
}
