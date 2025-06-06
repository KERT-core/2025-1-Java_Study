package com.javachip.study.config;

import com.javachip.study.domain.UserEntity;
import com.javachip.study.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepo;

    public CustomUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return new CustomUserDetails(user);
    }

    public UserDetails loadUserByStudentId(Long studentId){
        UserEntity user = userRepo.findByStudentId(studentId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + studentId));
        return new CustomUserDetails(user);
    }
}