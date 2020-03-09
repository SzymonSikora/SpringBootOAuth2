package com.webservice.dexter_service.Controller;

import com.webservice.dexter_service.Common.Enums.Enums;
import com.webservice.dexter_service.Common.Utils.Permission;
import com.webservice.dexter_service.Model.Entity.Account;
import com.webservice.dexter_service.Model.Entity.Role;
import com.webservice.dexter_service.Security.CustomUserDetail;
import com.webservice.dexter_service.Security.UserSession;
import com.webservice.dexter_service.Services.Implementations.AccountServiceImpl;
import com.webservice.dexter_service.Services.Implementations.RoleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountServiceImpl accountService;

    @Autowired
    private RoleServiceImpl roleService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Enums.REQUESTS.ACCOUNT.GET_ONE_BY_ID, method = RequestMethod.GET)
    private ResponseEntity<Account> getOne(@RequestParam(name = "ID") Integer id) {

        Account account = accountService.getOne(id);
        if (account == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Enums.REQUESTS.ACCOUNT.GET_ALL, method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getAll(@RequestParam(defaultValue = "false", required = false) Boolean isActive) {
        List<Account> account = accountService.getAll(isActive);
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (account == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        List<Account> optionalAccount = accountService.getRepository().findAll(new Specification<Account>() {
            @Override
            public Predicate toPredicate(Root<Account> r, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(cb.equal(r.get("isActive"), isActive));
                predicates.add(cb.equal(r.get(Enums.TABLES.ACCOUNT.USERNAME), "Username1"));
                predicates.add(cb.like(r.get(Enums.TABLES.ACCOUNT.EMAIL), "username1"));
                Predicate[] predicates1 = predicates.toArray(new Predicate[0]);
                return cq.where(cb.and(predicates.toArray(new Predicate[0]))).getRestriction();
            }
        });
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Enums.REQUESTS.ACCOUNT.CREATE, method = RequestMethod.POST)
    private ResponseEntity<Account> createAccount(@RequestBody Account account) throws Exception {
        if (!accountService.isExist(account)) {
            accountService.getRepository().findAll();
            if (account.getRoles() == null || account.getRoles().isEmpty()) {
                Set<Role> defaultRoles = roleService.getDefault();
                if (defaultRoles == null || defaultRoles.isEmpty()) {
                    throw new Exception("No any role");
                }

                account.setRoles(defaultRoles);
            }
        } else {
            throw new Exception("Account already exist");
        }

        account = accountService.saveOrUpdate(account);

        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Enums.REQUESTS.ACCOUNT.GET_AUTH_ACCOUNT, method = RequestMethod.GET)
    private ResponseEntity<Account> getOne() {
        CustomUserDetail loggedUser = UserSession.getUserSession();
        String username = loggedUser.getUsername();
        Account account = accountService.getOne(username);

        if (account == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
