package edu.miu.postbackend.repo;

import edu.miu.postbackend.domain.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepository extends JpaRepository<Logger, Long> {
}
