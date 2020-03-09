package com.webservice.dexter_service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webservice.dexter_service.Model.Entity.Account;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {

    @Query(value = "SELECT * FROM account u where u.is_active = :IS_ACTIVE"
            , nativeQuery = true)
    List<Account> findAllWhereUserIsActive(@Param("IS_ACTIVE") Boolean is_active);

    @Query(value = "SELECT * FROM account u where u.username = :USERNAME"
            , nativeQuery = true)
    Account findByUsername(@Param("USERNAME") String username);

    @Query(value = "SELECT * FROM account u where u.username = :USERNAME and u.password = :PASSWORD"
            , nativeQuery = true)
    Account findByUsernameAndPassword(@Param("USERNAME") String username, @Param("PASSWORD") String password);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM account where id_account = :ID_ACCOUNT"
            , nativeQuery = true)
    int deleteAccountById(@Param("ID_ACCOUNT") Integer id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM account_role WHERE id_account = :ID_ACCOUNT"
            , nativeQuery = true)
    int deleteAccountRoles(@Param("ID_ACCOUNT") Integer idAccount);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM account_role WHERE id_account = :ID_ACCOUNT AND id_role = :ID_ROLE"
            , nativeQuery = true)
    int deleteAccountRole(@Param("ID_ACCOUNT") Integer idAccount, @Param("ID_ROLE") Integer idRole);

    @Query(value = "SELECT * FROM account u where u.username = :USERNAME or u.email = :EMAIL"
            , nativeQuery = true)
    List<Account> isExistAccount(@Param("USERNAME") String username, @Param("EMAIL") String email);

}
