package com.webservice.dexter_service.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.webservice.dexter_service.Common.Enums.Enums;
import com.webservice.dexter_service.Model.DTO.AccountDTO;
import com.webservice.dexter_service.Model.Exceptions.ValidateException;
import com.webservice.dexter_service.Model.Interface.IMapperEntity;
import com.webservice.dexter_service.Model.Validators.DataValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;


@Entity
@Table(name = Enums.TABLES.ACCOUNT.ACCOUNT, uniqueConstraints = {
        @UniqueConstraint(columnNames = Enums.TABLES.ACCOUNT.ID_ACCOUNT),
        @UniqueConstraint(columnNames = Enums.TABLES.ACCOUNT.USERNAME),
        @UniqueConstraint(columnNames = Enums.TABLES.ACCOUNT.EMAIL)
})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Account extends BaseEntity implements Serializable, IMapperEntity<Account, AccountDTO> {

    @Transient
    @JsonIgnore
    private static final Logger logger = LoggerFactory.getLogger(Account.class);

    public Account(Integer idAccount, String username, @Size(max = 200, min = 10) String password, @Size(max = 30) String email, Boolean isActive, Date createdDate, Date deactivationDate, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.deactivationDate = deactivationDate;
        this.roles = roles;
    }

    public Account() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Enums.TABLES.ACCOUNT.ID_ACCOUNT, unique = true, nullable = false)
    private Integer idAccount;

    @Column(name = Enums.TABLES.ACCOUNT.USERNAME, unique = true, nullable = false)
    private String username;

    @Column(name = Enums.TABLES.ACCOUNT.PASSWORD)
    @Size(max = 200, min = 10)
    private String password;

    @Column(name = Enums.TABLES.ACCOUNT.EMAIL, unique = true, nullable = false)
    @Size(max = 30)
    private String email;

    @Column(name = Enums.TABLES.ACCOUNT.IS_ACTIVE)
    private Boolean isActive;

    @Column(name = Enums.TABLES.ACCOUNT.CREATE_DATE, updatable = false)
    private Date createdDate;

    @Column(name = Enums.TABLES.ACCOUNT.DEACTIVATION_DATE)
    private Date deactivationDate;

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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = Enums.TABLES.ACCOUNT_ROLE.ACCOUNT_ROLE,
            joinColumns = @JoinColumn(name = Enums.TABLES.ACCOUNT_ROLE.ID_ACCOUNT, unique = false, nullable = false),
            inverseJoinColumns = @JoinColumn(name = Enums.TABLES.ACCOUNT_ROLE.ID_ROLE, unique = false, nullable = false))
    private Set<Role> roles;

    public void setEmail(String email) {
        if (DataValidator.validateEmail(email)) {
            this.email = email;
        } else {
            String message = String.format("The email address is incorrect, email: %s", email);
            logger.error(message);
            throw new ValidateException(message);
        }
    }

    @PrePersist
    protected void lockDataBeforeInsert() {
        this.createdDate = new Date();
        this.isActive = true;
    }

    @PreUpdate
    protected void lockDataBeforeUpdate() {

    }

    @Override
    public AccountDTO getDtoObject(Object... args) {
        return new AccountDTO(
                idAccount,
                username,
                password,
                email,
                isActive,
                createdDate,
                deactivationDate,
                (roles != null)
                        ? roles.stream().map(Role::getIdRole).collect(Collectors.toSet())
                        : new HashSet<>()
                );
    }
}
