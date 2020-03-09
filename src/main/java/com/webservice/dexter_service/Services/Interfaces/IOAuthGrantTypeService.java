package com.webservice.dexter_service.Services.Interfaces;

import com.webservice.dexter_service.Model.Entity.OAuthGrantType;
import com.webservice.dexter_service.Repository.IOAuthGrantTypeRepository;

import java.util.Collection;

public interface IOAuthGrantTypeService {

    IOAuthGrantTypeRepository getRepository();

    OAuthGrantType saveOrUpdate(OAuthGrantType entity);

    OAuthGrantType getOne(Integer id);

    Boolean delete(Integer id);

    Collection<OAuthGrantType> getAll();
}
