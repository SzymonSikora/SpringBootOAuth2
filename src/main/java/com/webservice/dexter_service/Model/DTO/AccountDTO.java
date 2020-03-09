package com.webservice.dexter_service.Model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webservice.dexter_service.Model.Entity.Account;
import com.webservice.dexter_service.Model.Entity.Role;
import com.webservice.dexter_service.Model.Exceptions.ValidateException;
import com.webservice.dexter_service.Model.Interface.IMapperDto;
import com.webservice.dexter_service.Model.Validators.DataValidator;
import com.webservice.dexter_service.Services.Interfaces.IRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountDTO extends BaseDTO implements Serializable, IMapperDto<AccountDTO, Account> {

    @JsonIgnore
    private static final Logger logger = LoggerFactory.getLogger(AccountDTO.class);

    private Integer idAccount;
    private String username;
    @Size(max = 200, min = 10)
    private String password;
    @Size(max = 30)
    private String email;
    private Boolean isActive;
    private Date createdDate;
    private Date deactivationDate;
    private Set<Integer> roles;

    public AccountDTO(Integer idAccount, String username, @Size(max = 200, min = 10) String password, @Size(max = 30) String email, Boolean isActive, Date createdDate, Date deactivationDate, Set<Integer> roles) {
        this.idAccount = idAccount;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.deactivationDate = deactivationDate;
        this.roles = roles;
    }

    public AccountDTO() {

    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getDeactivationDate() {
        return deactivationDate;
    }

    public void setDeactivationDate(Date deactivationDate) {
        this.deactivationDate = deactivationDate;
    }

    public Set<Integer> getRoles() {
        return roles;
    }

    public void setRoles(Set<Integer> roles) {
        this.roles = roles;
    }

    public void setEmail(String email) {
        if (DataValidator.validateEmail(email)) {
            this.email = email;
        } else {
            String message = String.format("The email address is incorrect, email: %s", email);
            logger.error(message);
            throw new ValidateException(message);
        }
    }

    @Override
    public Account getEntityObject(Object... args) {
        Set<Role> rolesEntity = null;
        if(args[0] instanceof IRoleService) {
            IRoleService roleService = (IRoleService) args[0];
            rolesEntity = roleService.getRepository().findAllById(roles).stream().collect(Collectors.toSet());
        } else {
            rolesEntity = new HashSet<>();
        }

        return new Account(
                this.idAccount,
                this.username,
                this.password,
                this.email,
                this.isActive,
                this.createdDate,
                this.deactivationDate,
                rolesEntity
        );
    }
}
