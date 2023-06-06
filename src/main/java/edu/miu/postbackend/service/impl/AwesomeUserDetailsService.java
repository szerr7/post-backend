package edu.miu.postbackend.service.impl;


import edu.miu.postbackend.domain.UserAuth;
import edu.miu.postbackend.repo.UserAuthRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Transactional
public class AwesomeUserDetailsService implements UserDetailsService {

    private final UserAuthRepo userAuthRepo;

    public AwesomeUserDetailsService(UserAuthRepo userAuthRepo) {
        this.userAuthRepo = userAuthRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userAuthRepo.findByEmail(username);
        var userDetails = new AwesomeUserDetails(user);
        return userDetails;
    }

}
