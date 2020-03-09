package com.webservice.dexter_service.Services.Implementations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.webservice.dexter_service.Model.Entity.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.dexter_service.Repository.IAccountRepository;
import com.webservice.dexter_service.Services.Interfaces.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public IAccountRepository getRepository() {
        return accountRepository;
    }

    @Override
    public Account saveOrUpdate(Account entity) {
        try {
            return accountRepository.save(entity);
        } catch (Exception e) {
            logger.error(String.format("SaveOrUpdate account failed for: Id: %s, Username: %s, Email: %s", entity.getIdAccount(), entity.getUsername(), entity.getEmail()));
            return null;
        }
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            logger.info(String.format("IdAccount to remove: %s", id));
            int removedRolesResult = accountRepository.deleteAccountRoles(id);
            logger.info(String.format("Count of removed roles: %s", removedRolesResult));
            int removedAccountResult = accountRepository.deleteAccountById(id);
            logger.info(String.format("Count of removed account: %s", removedAccountResult));
        } catch (Exception e) {
            logger.error("An error occurred while deleting the account");
            return false;
        }
        return true;
    }

    @Override
    public List<Account> getAll() {
        try {
            return accountRepository.findAll();
        } catch (Exception e) {
            logger.error("An error occurred while getting all accounts");
            return new ArrayList<Account>();
        }
    }

    @Override
    public Account getOne(Integer id) {
        try {
            return accountRepository.getOne(id);
        } catch (Exception e) {
            logger.error(String.format("An error occurred while getting account by id: %s", id));
            return null;
        }
    }

    @Override
    public Account getOne(String username) {
        try {
            return accountRepository.findByUsername(username);
        } catch (Exception e) {
            logger.error(String.format("An error occurred while getting account by username: %s", username));
            return null;
        }
    }

    @Override
    public Boolean deactivation(Integer id) {
        try {
            Account u = accountRepository.getOne(id);
            if (u == null) {
                logger.info(String.format("Account not found for id: %s", id));
                return false;
            }
            u.setIsActive(false);
            u.setDeactivationDate(new Date());
            accountRepository.save(u);
            return true;

        } catch (Exception e) {
            logger.error(String.format("An error occurred while deactivation account by id: %s", id));
            return false;
        }
    }

    @Override
    public List<Account> getAll(Boolean isActive) {
        try {
            return accountRepository.findAllWhereUserIsActive(isActive);
        } catch (Exception e) {
            logger.error(String.format("An error occurred while getting all accounts with flag isActive: %s", isActive));
            return new ArrayList<Account>();
        }
    }

    @Override
    public Account findByUsername(String username) {
        try {
            return accountRepository.findByUsername(username);
        } catch (Exception e) {
            logger.error(String.format("An error occurred while getting account by username: %s", username));
            return null;
        }
    }

    @Override
    public Boolean isExist(Account account) {
        try {
            List<Account> existingAccounts = accountRepository.isExistAccount(account.getUsername(), account.getEmail());
            if (existingAccounts != null && !existingAccounts.isEmpty()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return true;
        }
    }

}
