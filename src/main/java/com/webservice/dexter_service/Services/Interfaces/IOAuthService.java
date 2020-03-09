package com.webservice.dexter_service.Services.Interfaces;

import com.webservice.dexter_service.Model.Entity.OAuthClient;
import com.webservice.dexter_service.Repository.IOAuthRepository;

import java.util.List;


public interface IOAuthService {
    //CRUD
    IOAuthRepository getRepository();

    OAuthClient saveOrUpdate(OAuthClient entity);

    Boolean delete(String id);

    List<OAuthClient> getAll();

    OAuthClient getOneByClientId(String clientId);
}
