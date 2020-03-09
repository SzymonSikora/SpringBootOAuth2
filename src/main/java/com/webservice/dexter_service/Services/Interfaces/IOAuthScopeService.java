package com.webservice.dexter_service.Services.Interfaces;

import com.webservice.dexter_service.Model.Entity.OAuthScope;
import com.webservice.dexter_service.Repository.IOAuthScopeRepository;

import java.util.Collection;

public interface IOAuthScopeService {

    IOAuthScopeRepository getRepository();

    OAuthScope saveOrUpdate(OAuthScope entity);

    OAuthScope getOne(Integer id);

    Boolean delete(Integer id);

    Collection<OAuthScope> getAll();
}
