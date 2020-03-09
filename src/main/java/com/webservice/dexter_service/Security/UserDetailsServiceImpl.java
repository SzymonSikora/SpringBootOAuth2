package com.webservice.dexter_service.Security;

import com.webservice.dexter_service.Model.Entity.Account;
import com.webservice.dexter_service.Services.Implementations.AccountServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    AccountServiceImpl accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findByUsername(username);

        if (account == null) {
            String exMess = String.format("Username: %s was not found in the database", username);
            logger.info(exMess);
            throw new UsernameNotFoundException(exMess);
        }

        if (account.getRoles().isEmpty()) {
            String exMess = String.format("Account doesn't have any roles, IdAccount: %s", account.getIdAccount());
            logger.info(exMess);
            throw new UsernameNotFoundException(exMess);
        }

        List<GrantedAuthority> grandList = new ArrayList<>();
        account.getRoles().forEach(value -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(value.getName());
            grandList.add(authority);
        });

        //TODO - uzuepłnij
        Set<Integer> permissions = new HashSet<>();
        return new CustomUserDetail(account.getUsername(), account.getPassword(), grandList, permissions);
    }
}
