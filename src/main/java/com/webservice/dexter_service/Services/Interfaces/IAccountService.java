package com.webservice.dexter_service.Services.Interfaces;

import java.util.Collection;
import java.util.List;

import com.webservice.dexter_service.Model.Entity.Account;
import com.webservice.dexter_service.Repository.IAccountRepository;

public interface IAccountService {
    //CRUD
    IAccountRepository getRepository();

    Account saveOrUpdate(Account entity);

    Boolean delete(Integer id);

    List<Account> getAll();

    List<Account> getAll(Boolean isActive);

    Account getOne(Integer id);

    Account getOne(String username);

    Boolean deactivation(Integer id);

    Account findByUsername(String username);

    Boolean isExist(Account account);
}
