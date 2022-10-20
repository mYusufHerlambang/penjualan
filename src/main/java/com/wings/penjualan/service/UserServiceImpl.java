package com.wings.penjualan.service;

import com.wings.penjualan.ApplicationUserDetail;
import com.wings.penjualan.dto.user.UserRegisterDTO;
import com.wings.penjualan.entity.Login;
import com.wings.penjualan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(UserRegisterDTO userRegisterDTO) {

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Login> userOptionalById = userRepository.findById(username);

        Login tempUser = null;

        if (userOptionalById.isPresent()){
            tempUser = userOptionalById.get();
        }
        return new ApplicationUserDetail(tempUser);
    }
}
