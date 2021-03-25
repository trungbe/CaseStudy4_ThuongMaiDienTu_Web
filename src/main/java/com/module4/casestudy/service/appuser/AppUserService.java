package com.module4.casestudy.service.appuser;

import com.module4.casestudy.model.LoginUser;
import com.module4.casestudy.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService implements IAppUserService, UserDetailsService {
    @Autowired
    private AppUserRepository appUserRepository;


    @Override
    public LoginUser getUserByUserName(String username) {
        return appUserRepository.getLoginUserByUsername(username);
    }

    @Override
    public LoginUser getCurrentUser() {
        LoginUser loginUser;
        String name;
        Object ob = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (ob instanceof UserDetails){
            name = ((UserDetails)ob).getUsername();
        }
        else {
            name = ob.toString();
        }
        loginUser = this.getUserByUserName(name);
        return loginUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUser loginUser= this.getUserByUserName(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(loginUser.getUserRole());
        UserDetails userDetails = new User(
                loginUser.getUsername(),
                loginUser.getPassword(),
                authorities
        );
        return userDetails;
    }
}
