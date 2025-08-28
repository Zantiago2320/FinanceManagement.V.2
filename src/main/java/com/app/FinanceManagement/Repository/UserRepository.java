package com.app.FinanceManagement.Repository;

import com.app.FinanceManagement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> findAllByEnabledTrue();

    Optional<User> findByIdAndEnabledTrue(Long id);
}
