package com.webservice.dexter_service.Repository;

import com.webservice.dexter_service.Model.Entity.OAuthScope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IOAuthScopeRepository extends JpaRepository<OAuthScope, Integer>, JpaSpecificationExecutor<OAuthScope> {
}
