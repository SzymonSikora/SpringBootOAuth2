package com.webservice.dexter_service.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.webservice.dexter_service.Model.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {

    @Query(value = "SELECT COUNT(*) FROM account_role WHERE id_role = :ID_ROLE"
            , nativeQuery = true)
    Integer isRoleUsed(@Param("ID_ROLE") Integer idRole);

    @Query(value = "SELECT COUNT(*) FROM role WHERE name in (:NAMES)"
            , nativeQuery = true)
    Set<Role> getRolesByNames(@Param("NAMES") Collection<String> names);

}
