package com.webservice.dexter_service.Repository;

import com.webservice.dexter_service.Model.Entity.OAuthClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface IOAuthRepository extends JpaRepository<OAuthClient, String>, JpaSpecificationExecutor<OAuthClient> {

    @Query(value = "SELECT * FROM oauth_client oa where oa.id_client = :ID_CLIENT"
            , nativeQuery = true)
    OAuthClient getOneByClientId(@Param("ID_CLIENT") String idClient);

}
