package com.webservice.dexter_service.Repository;

import com.webservice.dexter_service.Model.Entity.OAuthGrantType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IOAuthGrantTypeRepository extends JpaRepository<OAuthGrantType, Integer>, JpaSpecificationExecutor<OAuthGrantType> {
}
