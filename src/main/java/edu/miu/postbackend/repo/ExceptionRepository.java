package edu.miu.postbackend.repo;

import edu.miu.postbackend.domain.ExceptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExceptionRepository extends JpaRepository<ExceptionEntity, Long> {
}
