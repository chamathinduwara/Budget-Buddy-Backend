package com.chamath.budgetbuddy.services;

import com.chamath.budgetbuddy.dao.UserDetailsDao;
import com.chamath.budgetbuddy.models.UserEntity;
import com.chamath.budgetbuddy.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServices implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user =  userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User is not found" + username);
        }
        System.out.println(user.getRoles());
        return new UserDetailsDao(user);
    }
}
