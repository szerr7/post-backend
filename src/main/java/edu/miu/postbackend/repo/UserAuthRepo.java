package edu.miu.postbackend.repo;

import edu.miu.postbackend.domain.UserAuth;
import org.springframework.data.repository.CrudRepository;

public interface UserAuthRepo extends CrudRepository<UserAuth, Long> {

    UserAuth findByEmail(String email) ;



}
