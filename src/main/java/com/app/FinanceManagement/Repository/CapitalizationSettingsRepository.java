package com.app.FinanceManagement.Repository;

import com.app.FinanceManagement.Entity.CapitalizationsSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapitalizationSettingsRepository extends JpaRepository<CapitalizationsSettings, Long> {
}
